package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateStorageRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetStorageRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.MetaDataWithTotalRecord;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.mapper.StorageResourceMapper;
import vn.edu.hust.project.appledeviceservice.service.IStorageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ops/api/v1/storages")
public class StorageController {

    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private final IStorageService storageService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Resource> createStorage(
            @RequestBody CreateStorageRequest createStorageRequest
    ) {
        return ResponseEntity.ok(
                new Resource(storageService.
                        createStorage(StorageResourceMapper.INSTANCE.toStorageEntityFromRequest(createStorageRequest)))
        );
    }

    @GetMapping
    public ResponseEntity<Resource> getAll(
            @RequestParam(required = false, name = "volume") Long volume,
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize
    ) {
        var filter = new GetStorageRequest();
        filter.setVolume(volume);
        filter.setPage(page);
        filter.setPageSize(pageSize);

        var result = storageService.getAllStorage(filter);

        var pageInfo = result.getFirst();

        var metaData = new MetaDataWithTotalRecord(pageInfo.getTotalRecord(), pageInfo.getPageSize(),
                pageInfo.getTotalPage(), pageInfo.getNextPage(), pageInfo.getPreviousPage());

        var resource = new Resource(result.getSecond(), metaData);

        return ResponseEntity.ok(resource);
    }

    @GetMapping("/{storage_id}")
    public ResponseEntity<Resource> getDetail(
            @PathVariable(name = "storage_id") Long storageId
    ) {
        return ResponseEntity.ok(
                new Resource(storageService.getStorageById(storageId))
        );
    }


    @DeleteMapping("/{storage_id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Resource> deleteStorage(
            @PathVariable(name = "storage_id") Long storageId
    ) {
        storageService.deleteStorageById(storageId);
        return ResponseEntity.ok(new Resource(null));
    }
}
