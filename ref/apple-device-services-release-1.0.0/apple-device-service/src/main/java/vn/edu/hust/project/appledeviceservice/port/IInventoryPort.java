package vn.edu.hust.project.appledeviceservice.port;

import java.util.List;
import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetInventoryRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

public interface IInventoryPort {
    InventoryEntity save(InventoryEntity entity);

    Pair<PageInfo, List<InventoryEntity>> getAllInventory(GetInventoryRequest filter);

    List<InventoryEntity> getInventoryByProductDetailIds(List<Long> productDetailIds);

    InventoryEntity getInventoryByProductDetailId(Long productDetailId);
}
