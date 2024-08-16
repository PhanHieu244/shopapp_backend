package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.DistrictEntity;

public interface IDistrictPort {
    DistrictEntity getDistrictByCode(String code);

    DistrictEntity save(DistrictEntity districtEntity);
}
