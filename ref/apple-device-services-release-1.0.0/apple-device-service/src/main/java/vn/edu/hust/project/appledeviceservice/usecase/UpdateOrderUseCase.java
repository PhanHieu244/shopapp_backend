package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import vn.edu.hust.project.appledeviceservice.constant.OrderState;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.exception.UpdateOrderException;
import vn.edu.hust.project.appledeviceservice.port.IOrderLinePort;
import vn.edu.hust.project.appledeviceservice.port.IOrderPort;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateOrderUseCase {

    private final IOrderPort orderPort;
    private final IOrderLinePort orderLinePort;
    private final CancelOrderUseCase cancelOrderUseCase;

    @Transactional(rollbackFor = Exception.class)
    public OrderEntity confirmOrder(Long orderId) {
        var order = orderPort.getOrderById(orderId);
        if (ObjectUtils.isEmpty(order) || OrderState.CONFIRMED.name().equals(order.getState())) {
            throw new UpdateOrderException();
        }
        order.setState("CONFIRMED");
        return orderPort.save(order);
    }

    @Transactional(rollbackFor = Exception.class)
    public OrderEntity updateStateOrder(Long orderId, String state) {
        var order = orderPort.getOrderById(orderId);
        if (ObjectUtils.isEmpty(order) || !isStateValid(state, order.getState())) {
            throw new UpdateOrderException();
        }
        if(OrderState.CANCELLED.name().equals(state)){
            cancelOrderUseCase.cancelOrder(orderId, order);
            order.setState(state);
        }
        else {
            order.setState(state);
            order =  orderPort.save(order);
        }
        var orderLines = orderLinePort.getOrderLineByOrderIds(List.of(orderId));
        order.setOrderLines(orderLines);
        return order;
    }

    private Boolean isStateValid(String newState, String currentState) {
        return (OrderState.PENDING.name().equals(currentState) && OrderState.CONFIRMED.name().equals(newState)) ||
                (OrderState.CONFIRMED.name().equals(currentState) && OrderState.SHIPPING.name().equals(newState)) ||
                (OrderState.SHIPPING.name().equals(currentState) && OrderState.DELIVERED.name().equals(newState)) ||
                (OrderState.DELIVERED.name().equals(currentState) && OrderState.FINISHED.name().equals(newState)) ||
                (OrderState.FINISHED.name().equals(currentState) && OrderState.CANCELLED.name().equals(newState));
    }
}
