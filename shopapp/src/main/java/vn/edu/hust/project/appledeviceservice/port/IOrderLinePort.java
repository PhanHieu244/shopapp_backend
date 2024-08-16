package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;

import java.util.List;

public interface IOrderLinePort {
    List<OrderLineEntity> getOrderLineByOrderIds(List<Long> orderIds);

    OrderLineEntity save(OrderLineEntity orderLineEntity);

}
