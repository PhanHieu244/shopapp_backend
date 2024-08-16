package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.WardEntity;

public interface IWardPort {
    WardEntity getWardByCode(String code);

    WardEntity save(WardEntity wardEntity);
}
