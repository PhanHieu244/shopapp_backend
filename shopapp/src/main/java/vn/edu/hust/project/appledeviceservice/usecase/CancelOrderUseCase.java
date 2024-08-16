package vn.edu.hust.project.appledeviceservice.usecase;

import io.lettuce.core.RedisConnectionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import vn.edu.hust.project.appledeviceservice.constant.Key;
import vn.edu.hust.project.appledeviceservice.constant.OrderState;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;
import vn.edu.hust.project.appledeviceservice.exception.CancelOrderException;
import vn.edu.hust.project.appledeviceservice.exception.RedisConnectException;
import vn.edu.hust.project.appledeviceservice.port.IOrderLinePort;
import vn.edu.hust.project.appledeviceservice.port.IOrderPort;
import vn.edu.hust.project.appledeviceservice.port.IRedisPort;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CancelOrderUseCase {
    private final IOrderPort orderPort;
    private final IRedisPort redisPort;
    private final IOrderLinePort orderLinePort;
    private final ChangeInventoryUseCase changeInventoryUseCase;

    @Transactional(rollbackFor = Exception.class)
    public void cancelOrderOps(Long orderId) {
        cancelOrder(orderId, null);
    }

    public void cancelOrderWeb(Long orderId, Long userId) {
        var order = orderPort.getOrderByIdAndUserId(orderId, userId);
        if (ObjectUtils.isEmpty(order)){
            log.error("[CancelOrderUseCase] Order not found");
            throw new CancelOrderException();
        }
        cancelOrder(orderId, order);
    }

    public void cancelOrder(Long orderId, OrderEntity order) {
        if (ObjectUtils.isEmpty(order)) {
            order = orderPort.getOrderById(orderId);
        }

        if (ObjectUtils.isEmpty(order) || !OrderState.PENDING.name().equalsIgnoreCase(order.getState())) {
            log.error("[CancelOrderUseCase] Order not found or failed state");
            throw new CancelOrderException();
        }
        var orderLines = orderLinePort.getOrderLineByOrderIds(List.of(orderId));
        if (CollectionUtils.isEmpty(orderLines)) {
            log.error("[CancelOrderUseCase] Order lines not found");
            throw new CancelOrderException();
        }

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
        order.setState(OrderState.CANCELLED.name());
        orderPort.save(order);
    }
}
