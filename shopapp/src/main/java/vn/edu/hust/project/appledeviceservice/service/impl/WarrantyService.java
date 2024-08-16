package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.WarrantyEntity;
import vn.edu.hust.project.appledeviceservice.service.IWarrantyService;
import vn.edu.hust.project.appledeviceservice.usecase.GetWarrantyInfoUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarrantyService implements IWarrantyService {
    private final GetWarrantyInfoUseCase getWarrantyInfoUseCase;

    @Override
    public List<WarrantyEntity> getByOrderCode(String orderCode) {
        return getWarrantyInfoUseCase.getWarrantyInfo(orderCode);
    }
}
