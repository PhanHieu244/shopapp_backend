package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateOrderLineException;
import vn.edu.hust.project.appledeviceservice.port.IOrderLinePort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IOrderLineRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.OrderLineModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderLineAdapter implements IOrderLinePort {
    private final IOrderLineRepository orderLineRepository;

    @Override
    public List<OrderLineEntity> getOrderLineByOrderIds(List<Long> orderIds) {
        return OrderLineModelMapper.INSTANCE.toEntities(orderLineRepository.findByOrderIdIn(orderIds));
    }

    @Override
    public OrderLineEntity save(OrderLineEntity orderLineEntity) {
        try {
            var orderLineModel = OrderLineModelMapper.INSTANCE.toModel(orderLineEntity);
            orderLineModel = orderLineRepository.save(orderLineModel);
            return OrderLineModelMapper.INSTANCE.toEntity(orderLineModel);
        } catch (Exception e){
            log.error("[OrderLineAdapter] Can not save order line: err: " + e.getMessage());
            throw new CreateOrderLineException();
        }
    }
}
