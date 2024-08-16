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
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateColorRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetColorRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.MetaDataWithTotalRecord;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.mapper.ColorResourceMapper;
import vn.edu.hust.project.appledeviceservice.service.IColorService;

@RestController
@RequestMapping("/ops/api/v1/colors")
@RequiredArgsConstructor
public class ColorController {

    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private final IColorService colorService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Resource> createColor(
            @RequestBody CreateColorRequest request
    ) {
        var color = colorService.createColorEntity(ColorResourceMapper.INSTANCE.toEntity(request));
        return ResponseEntity.ok(new Resource(color));
    }

    @GetMapping
    public ResponseEntity<Resource> getAll(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize
    ) {
        var filter = new GetColorRequest();
        filter.setName(name);
        filter.setPage(page);
        filter.setPageSize(pageSize);

        var result = colorService.getAllColors(filter);

        var pageInfo = result.getFirst();

        var metaData = new MetaDataWithTotalRecord(pageInfo.getTotalRecord(), pageInfo.getPageSize(),
                pageInfo.getTotalPage(), pageInfo.getNextPage(), pageInfo.getPreviousPage());

        var resource = new Resource(result.getSecond(), metaData);

        return ResponseEntity.ok(resource);
    }

    @GetMapping("/{color_id}")
    public ResponseEntity<Resource> getColorDetail(
            @PathVariable(name = "color_id") Long colorId
    ){
        return ResponseEntity.ok(new Resource(colorService.getColorById(colorId)));
    }

    @PreAuthorize("ROLE_ADMIN")
    @DeleteMapping("/{color_id}")
    public ResponseEntity<Resource> deleteColor(
            @PathVariable(name = "color_id") Long colorId
    ){
        colorService.deleteColorById(colorId);
        return ResponseEntity.ok(new Resource(null));
    }

}
