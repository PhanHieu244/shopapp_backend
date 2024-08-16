package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.exception.ChangeInventoryException;
import vn.edu.hust.project.appledeviceservice.port.IInventoryPort;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChangeInventoryUseCase {
    private final IInventoryPort inventoryPort;
    public void changeInventoryForCreateOrder(Long productDetailId, Long quantity) {
        var inventory = inventoryPort.getInventoryByProductDetailId(productDetailId);
        if (inventory == null || quantity > inventory.getAvailable()) {
            log.error("[CreateOrderUseCase] Inventory is not enough");
            throw new ChangeInventoryException();
        }

        inventory.setAvailable(inventory.getAvailable() - quantity);
        inventory.setSold(inventory.getSold() + quantity);

        inventoryPort.save(inventory);
    }

    public void changeInventoryForCancelOrder(Long productDetailId, Long quantity) {
        var inventory = inventoryPort.getInventoryByProductDetailId(productDetailId);
        if (inventory == null || quantity > inventory.getAvailable() || inventory.getAvailable() + quantity > inventory.getAmount()) {
            log.error("[CreateOrderUseCase] Inventory is not enough");
            throw new ChangeInventoryException();
        }

        inventory.setAvailable(inventory.getAvailable() + quantity);
        inventory.setSold(inventory.getSold() - quantity);

        inventoryPort.save(inventory);
    }
}
