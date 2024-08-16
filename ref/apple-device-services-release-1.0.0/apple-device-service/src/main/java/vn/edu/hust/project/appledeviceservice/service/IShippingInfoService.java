package vn.edu.hust.project.appledeviceservice.service;

import vn.edu.hust.project.appledeviceservice.enitity.ShippingInfoEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateShippingInfoRequest;

public interface IShippingInfoService {
    ShippingInfoEntity createShippingInfo(CreateShippingInfoRequest request);
}
