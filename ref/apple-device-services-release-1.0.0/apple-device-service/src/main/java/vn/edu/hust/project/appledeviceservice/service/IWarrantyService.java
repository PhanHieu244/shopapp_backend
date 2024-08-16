package vn.edu.hust.project.appledeviceservice.service;

import vn.edu.hust.project.appledeviceservice.enitity.WarrantyEntity;

import java.util.List;

public interface IWarrantyService {
    List<WarrantyEntity> getByOrderCode(String orderCode);
}
