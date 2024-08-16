package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ShippingInfoModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface IShippingInfoRepository extends IBaseRepository<ShippingInfoModel>{
    Optional<ShippingInfoModel> findByUserIdAndId(Long userId, Long id);

    List<ShippingInfoModel> findByIdIn(List<Long> ids);
}
