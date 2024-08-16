package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateTypeRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetTypeRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.MetaDataWithTotalRecord;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.mapper.TypeResourceMapper;
import vn.edu.hust.project.appledeviceservice.service.ITypeService;

@RestController
@RequestMapping("/ops/api/v1/types")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TypeController {

    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private final ITypeService typeService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Resource> createType(
            @RequestBody CreateTypeRequest request
    ) {
        return ResponseEntity.ok(
                new Resource(typeService.createType(TypeResourceMapper.INSTANCE.fromRequest(request)))
        );
    }

    @GetMapping
    public ResponseEntity<Resource> getTypes(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize
    ) {
        var filter = new GetTypeRequest();
        filter.setName(name);
        filter.setPage(page);
        filter.setPageSize(pageSize);

        var result = typeService.getAllTypes(filter);

        var pageInfo = result.getFirst();

        var metaData = new MetaDataWithTotalRecord(pageInfo.getTotalRecord(), pageInfo.getPageSize(),
                pageInfo.getTotalPage(), pageInfo.getNextPage(), pageInfo.getPreviousPage());

        var resource = new Resource(result.getSecond(), metaData);

        return ResponseEntity.ok(resource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getById(
            @PathVariable(name = "id") Long id
    ) {
        return ResponseEntity.ok(
                new Resource(typeService.getTypeById(id))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Resource> deleteType(
            @PathVariable(name = "id") Long id
    ) {
        typeService.deleteTypeById(id);
        return ResponseEntity.ok(new Resource(null));
    }
}
