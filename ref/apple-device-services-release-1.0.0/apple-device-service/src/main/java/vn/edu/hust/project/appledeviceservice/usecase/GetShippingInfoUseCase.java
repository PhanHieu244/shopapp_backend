package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ShippingInfoEntity;
import vn.edu.hust.project.appledeviceservice.mapper.ShippingInfoResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.IDistrictPort;
import vn.edu.hust.project.appledeviceservice.port.IProvincePort;
import vn.edu.hust.project.appledeviceservice.port.IShippingInfoPort;
import vn.edu.hust.project.appledeviceservice.port.IWardPort;

@Service
@RequiredArgsConstructor
public class GetShippingInfoUseCase {
    private final IShippingInfoPort shippingInfoPort;
    private final IProvincePort provincePort;

    private final IDistrictPort districtPort;

    private final IWardPort wardPort;
    public ShippingInfoEntity getShippingInfoById(Long id) {
        var shipInfo = shippingInfoPort.getShippingInfoById(id);
        var province = provincePort.getProvinceByCode(shipInfo.getProvinceCode());
        var district = districtPort.getDistrictByCode(shipInfo.getDistrictCode());
        var ward = wardPort.getWardByCode(shipInfo.getWardCode());
        shipInfo.setProvince(province);
        shipInfo.setDistrict(district);
        shipInfo.setWard(ward);
        return shipInfo;
    }
}
