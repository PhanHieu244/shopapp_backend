package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.ProvinceEntity;

public interface IProvincePort {
    ProvinceEntity getProvinceByCode(String code);

    ProvinceEntity save(ProvinceEntity provinceEntity);
}
