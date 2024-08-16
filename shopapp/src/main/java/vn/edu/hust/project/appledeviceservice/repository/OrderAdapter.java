package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.exception.CreateOrderException;
import vn.edu.hust.project.appledeviceservice.exception.GetOrderException;
import vn.edu.hust.project.appledeviceservice.port.IOrderPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IOrderRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.OrderModelMapper;
import vn.edu.hust.project.appledeviceservice.repository.mysql.specification.OrderSpecification;
import vn.edu.hust.project.appledeviceservice.utils.PageInfoUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderAdapter implements IOrderPort {

    private final IOrderRepository orderRepository;

    @Override
    public Pair<PageInfo, List<OrderEntity>> getAllOrder(GetOrderRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());

        var result = orderRepository.findAll(new OrderSpecification(filter), pageable);

        var pageInfo = PageInfoUtils.getPageInfoUtils(result);

        return Pair.of(pageInfo, OrderModelMapper.INSTANCE.toEntities(result.getContent()));
    }

    @Override
    public OrderEntity save(OrderEntity orderEntity) {
        try {
            var orderModel = OrderModelMapper.INSTANCE.toModel(orderEntity);
            orderModel = orderRepository.save(orderModel);
            return OrderModelMapper.INSTANCE.toEntity(orderModel);
        } catch (Exception e) {
            log.error("[OrderAdapter] Can not save order: err: " + e.getMessage());
            throw new CreateOrderException();
        }

    }

    @Override
    public OrderEntity getOrderById(Long orderId) {
        return OrderModelMapper.INSTANCE.toEntity(orderRepository.findById(orderId).orElse(null));
    }

    @Override
    public OrderEntity getOrderByIdAndUserId(Long orderId, Long userId) {
        return OrderModelMapper.INSTANCE.toEntity(orderRepository.findByIdAndUserId(orderId, userId).orElse(null));
    }

    @Override
    public List<OrderEntity> getAll(GetOrderRequest filter) {
        return OrderModelMapper.INSTANCE.toEntities(orderRepository.findAll(new OrderSpecification(filter)));
    }

    @Override
    public OrderEntity getOrderByCode(String orderCode) {
        return OrderModelMapper.INSTANCE.toEntity(orderRepository.findByCode(orderCode).orElseThrow(
                () -> {
                    log.error("[OrderAdapter] Can not find order by code: " + orderCode);
                    return new GetOrderException();
                }
        ));
    }

}
