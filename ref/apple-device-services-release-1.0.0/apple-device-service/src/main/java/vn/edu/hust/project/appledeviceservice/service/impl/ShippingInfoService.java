package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ShippingInfoEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateShippingInfoRequest;
import vn.edu.hust.project.appledeviceservice.service.IShippingInfoService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateShippingInfoUseCase;

@Service
@RequiredArgsConstructor
public class ShippingInfoService implements IShippingInfoService {
    private final CreateShippingInfoUseCase createShippingInfoUseCase;

    @Override
    public ShippingInfoEntity createShippingInfo(CreateShippingInfoRequest request) {
        return createShippingInfoUseCase.createShippingInfo(request);
    }
}
