package vn.edu.hust.project.appledeviceservice.usecase;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetInventoryRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IInventoryPort;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetInventoryUseCase {
    private final IInventoryPort inventoryPort;

    public Pair<PageInfo, List<InventoryEntity>> getAllInventories(GetInventoryRequest filter) {
        return inventoryPort.getAllInventory(filter);
    }
}
