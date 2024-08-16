package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateInventoryRequest;
import vn.edu.hust.project.appledeviceservice.port.IInventoryPort;

@Service
@RequiredArgsConstructor
public class CreateInventoryUseCase {

    private static final Long DEFAULT_INVENTORY_SOLD = 0L;

    private final IInventoryPort inventoryPort;

    @Transactional(rollbackFor = Exception.class)
    public InventoryEntity createInventory(CreateInventoryRequest request){
        var inventory = new InventoryEntity();
        inventory.setAmount(request.getAmount());
        inventory.setProductDetailId(request.getProductDetailId());
        inventory.setSold(DEFAULT_INVENTORY_SOLD);
        inventory.setAvailable(request.getAmount());
        return inventoryPort.save(inventory);
    }
}
