package vn.edu.hust.project.appledeviceservice.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateInventoryRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetInventoryRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.service.IInventoryService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateInventoryUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.GetInventoryUseCase;

@Service
@RequiredArgsConstructor
public class InventoryService implements IInventoryService {

    private final CreateInventoryUseCase createInventoryUseCase;

    private final GetInventoryUseCase getInventoryUseCase;

    @Override
    public InventoryEntity createInventory(CreateInventoryRequest request) {
        return createInventoryUseCase.createInventory(request);
    }

    @Override
    public Pair<PageInfo, List<InventoryEntity>> getAllInventories(GetInventoryRequest filter) {
        return getInventoryUseCase.getAllInventories(filter);
    }
}
