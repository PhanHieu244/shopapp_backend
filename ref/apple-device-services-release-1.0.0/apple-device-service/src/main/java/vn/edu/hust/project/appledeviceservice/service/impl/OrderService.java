package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.service.IOrderService;
import vn.edu.hust.project.appledeviceservice.usecase.CancelOrderUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.CreateOrderUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.GetOrderUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.UpdateOrderUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final GetOrderUseCase getOrderUseCase;

    private final CreateOrderUseCase createOrderUseCase;

    private final UpdateOrderUseCase updateOrderUseCase;

    private final CancelOrderUseCase cancelOrderUseCase;

    @Override
    public Pair<PageInfo, List<OrderEntity>> getAllOrder(GetOrderRequest request) {
        return getOrderUseCase.getAllOrder(request);
    }

    @Override
    public OrderEntity createOrder(CreateOrderRequest request) {
        return createOrderUseCase.createOrder(request);
    }

    @Override
    public OrderEntity confirmOrder(Long orderId) {
        return updateOrderUseCase.confirmOrder(orderId);
    }

    @Override
    public OrderEntity updateStateOrderOps(Long orderId, String state) {
        return updateOrderUseCase.updateStateOrder(orderId, state);
    }

    @Override
    public void cancelOrderWeb(Long orderId, Long userId) {
        cancelOrderUseCase.cancelOrderWeb(orderId, userId);
    }

    @Override
    public OrderEntity getById(Long orderId) {
        return getOrderUseCase.getOrderById(orderId);
    }

    @Override
    public OrderEntity getOrderByIdAndUserID(Long orderId, Long userId) {
        return getOrderUseCase.getOrderByIdAndUserID(orderId, userId);
    }
}
