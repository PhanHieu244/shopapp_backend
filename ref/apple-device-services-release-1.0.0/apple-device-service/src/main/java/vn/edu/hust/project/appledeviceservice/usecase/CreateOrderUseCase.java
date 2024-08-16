package vn.edu.hust.project.appledeviceservice.usecase;


import io.lettuce.core.RedisConnectionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import vn.edu.hust.project.appledeviceservice.constant.Key;
import vn.edu.hust.project.appledeviceservice.constant.OrderState;
import vn.edu.hust.project.appledeviceservice.enitity.BaseEntity;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateOrderRequest;
import vn.edu.hust.project.appledeviceservice.exception.ChangeInventoryException;
import vn.edu.hust.project.appledeviceservice.exception.CreateOrderException;
import vn.edu.hust.project.appledeviceservice.exception.NotEnoughInventoryException;
import vn.edu.hust.project.appledeviceservice.exception.RedisConnectException;
import vn.edu.hust.project.appledeviceservice.mapper.OrderResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.IOrderLinePort;
import vn.edu.hust.project.appledeviceservice.port.IOrderPort;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;
import vn.edu.hust.project.appledeviceservice.port.IRedisPort;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateOrderUseCase {

    private final IOrderPort orderPort;
    private final IRedisPort redisPort;
    private final IOrderLinePort orderLinePort;
    private final IProductDetailPort productDetailPort;
    private final ChangeInventoryUseCase changeInventoryUseCase;
    private final CreateShippingInfoUseCase createShippingInfoUseCase;
    private final DeleteCartUseCase deleteCartUseCase;
    private final GetCartUseCase getCartUseCase;


    @Transactional(rollbackFor = Exception.class)
    public OrderEntity createOrder(CreateOrderRequest createOrderRequest) {
        try {

            if (createOrderRequest == null) {
                log.error("[CreateOrderUseCase] Create order request is null");
                throw new CreateOrderException();
            }
            if (createOrderRequest.getShippingInfo() == null) {
                log.error("[CreateOrderUseCase] Shipping info is null");
                throw new CreateOrderException();
            }

            if (CollectionUtils.isEmpty(createOrderRequest.getCartIds())) {
                log.error("[CreateOrderUseCase] Cart ids is empty");
                throw new CreateOrderException();
            }


            var shippingInfoRequest = createOrderRequest.getShippingInfo();
            var shippingInfo = createShippingInfoUseCase.createShippingInfo(shippingInfoRequest);

            var carts = getCartUseCase.getCartsByIds(createOrderRequest.getCartIds());
            if (CollectionUtils.isEmpty(carts)) {
                log.error("[CreateOrderUseCase] Carts is empty");
                throw new CreateOrderException();
            }


            var orderLines = carts.stream()
                    .map(cart -> {
                        var orderLine = new OrderLineEntity();
                        orderLine.setProductDetailId(cart.getProductDetailId());
                        orderLine.setQuantity(cart.getQuantity());
                        return orderLine;
                    })
                    .toList();
            if (CollectionUtils.isEmpty(orderLines)) {
                log.error("[CreateOrderUseCase] Order lines is empty");
                throw new CreateOrderException();
            }

            var productDetailIds = orderLines.stream()
                    .map(orderLine -> orderLine.getProductDetailId())
                    .collect(Collectors.toList());
            var productDetails = productDetailPort.getProductDetailByIds(productDetailIds);
            var mapProductDetail = productDetails.stream()
                    .collect(Collectors.toMap(ProductDetailEntity::getId, Function.identity()));
            var totalPrice = orderLines.stream()
                    .map(orderLine -> {
                        var productDetail = mapProductDetail.get(orderLine.getProductDetailId());
                        return productDetail.getPrice() * orderLine.getQuantity();
                    })
                    .reduce(0L, Long::sum);


            var order = OrderResourceMapper.INSTANCE.createOrderFromRequest(createOrderRequest);

            order.setShippingInfoId(shippingInfo.getId());
            order.setState(OrderState.PENDING.name());
            order.setTotalPrice(totalPrice);
            order = orderPort.save(order);

            var orderLineEntities = new ArrayList<OrderLineEntity>();
            for (var orderLine : orderLines) {
                var lockKey =
                        Key.INVENTORY_PRODUCT_DETAIL.getPrefixKey() + orderLine.getProductDetailId();
                var newOrderLine = new OrderLineEntity();
                newOrderLine.setOrderId(order.getId());
                newOrderLine.setProductDetailId(orderLine.getProductDetailId());
                newOrderLine.setQuantity(orderLine.getQuantity());

                while (true) {
                    try {
                        if (Boolean.TRUE.equals(
                                redisPort.lockKey(lockKey, order.getId().toString(), 10L))) {
                            changeInventoryUseCase.changeInventoryForCreateOrder(orderLine.getProductDetailId(),
                                    orderLine.getQuantity());
                            orderLineEntities.add(orderLinePort.save(newOrderLine));
                            break;
                        }
                    } catch (RedisConnectionException e) {
                        log.error("[CreateOrderUseCase] Redis connect fail, err: " + e.getMessage());
                        throw new RedisConnectException();
                    } finally {
                        log.info("[CreateOrderUseCase] Release lock key: " + lockKey);
                        redisPort.deleteKey(lockKey);
                    }

                    // If the lock could not be acquired, wait for a short time before trying again
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException("Thread was interrupted", e);
                    }
                }
            }
            deleteCartUseCase.deleteCartByIds(createOrderRequest.getCartIds());
            order.setOrderLines(orderLineEntities);
            order.setShippingInfo(shippingInfo);
            return order;
        } catch (ChangeInventoryException ex) {
            throw new NotEnoughInventoryException();
        } catch (Exception ex) {
            throw new CreateOrderException();
        }

    }

}
