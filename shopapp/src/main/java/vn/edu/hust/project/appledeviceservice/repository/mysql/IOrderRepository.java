package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.OrderModel;

import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<OrderModel, Long>, JpaSpecificationExecutor<OrderModel> {

    Optional<OrderModel> findByIdAndUserId(Long orderId, Long userId);

     Optional<OrderModel> findByCode(String code);
}
