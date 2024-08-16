package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateInventoryRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetInventoryRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IInventoryService;

@RestController
@RequestMapping("/ops/api/v1/inventories")
@RequiredArgsConstructor
public class InventoryController {

    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private final IInventoryService inventoryService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    ResponseEntity<Resource> createInventory(
        @RequestBody CreateInventoryRequest request
    ) {
        return ResponseEntity.ok(new Resource(
            inventoryService.createInventory(request)
        ));
    }

    @GetMapping
    ResponseEntity<Resource> getAllInventories(
        @RequestParam(required = false, name = "product_detail_id") Long productDetailId,
        @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize
    ) {
        var filter = new GetInventoryRequest();
        filter.setProductDetailId(productDetailId);
        filter.setPage(page);
        filter.setPageSize(pageSize);

        return ResponseEntity.ok(new Resource(
            inventoryService.getAllInventories(filter)
        ));
    }
}
