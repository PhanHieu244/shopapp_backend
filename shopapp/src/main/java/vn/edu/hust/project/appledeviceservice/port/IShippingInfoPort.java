package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.ShippingInfoEntity;

import java.util.List;

public interface IShippingInfoPort {
    ShippingInfoEntity save(ShippingInfoEntity shippingInfoEntity);

    ShippingInfoEntity getInfoByUserIdAndId(Long userId, Long id);

    List<ShippingInfoEntity> getInfoByIds(List<Long> ids);

    ShippingInfoEntity getShippingInfoById(Long id);
}
