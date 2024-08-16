package vn.edu.hust.project.appledeviceservice.port;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;

public interface IOrderPort {
    Pair<PageInfo, List<OrderEntity>> getAllOrder(GetOrderRequest request);

    OrderEntity save(OrderEntity orderEntity);

    OrderEntity getOrderById(Long orderId);

    OrderEntity getOrderByIdAndUserId(Long orderId, Long userId);

    List<OrderEntity> getAll(GetOrderRequest request);

    OrderEntity getOrderByCode(String orderCode);

}
