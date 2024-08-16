package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.OrderLineModel;

import java.util.List;
@Repository
public interface IOrderLineRepository extends IBaseRepository<OrderLineModel> {
    List<OrderLineModel> findByOrderIdIn(List<Long> orderIds);
}
