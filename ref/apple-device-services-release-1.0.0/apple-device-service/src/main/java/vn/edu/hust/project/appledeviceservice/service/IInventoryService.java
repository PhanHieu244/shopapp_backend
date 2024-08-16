package vn.edu.hust.project.appledeviceservice.service;

import java.util.List;
import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateInventoryRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetInventoryRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

public interface IInventoryService {
    InventoryEntity createInventory(CreateInventoryRequest request);

    Pair<PageInfo, List<InventoryEntity>> getAllInventories(GetInventoryRequest filter);
}
