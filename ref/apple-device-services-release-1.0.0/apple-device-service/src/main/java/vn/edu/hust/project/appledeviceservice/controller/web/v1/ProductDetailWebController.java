package vn.edu.hust.project.appledeviceservice.controller.web.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequestWeb;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.MetaDataWithTotalRecord;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IProductDetailService;

@RestController
@RequestMapping("/web/api/v1/product_details")
@RequiredArgsConstructor
public class ProductDetailWebController {
    private final IProductDetailService productDetailService;
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    @GetMapping
    public ResponseEntity<Resource> getALlProductDetails(
            @RequestParam(required = false, name = "type") String type,
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize
    ) {
        var filter = new GetProductDetailRequestWeb();
        filter.setPage(page);
        filter.setPageSize(pageSize);
        filter.setType(type);

        var result = productDetailService.getAllProductDetailsWeb(filter);

        var pageInfo = result.getFirst();

        var metaData = new MetaDataWithTotalRecord(pageInfo.getTotalRecord(), pageInfo.getPageSize(),
                pageInfo.getTotalPage(), pageInfo.getNextPage(), pageInfo.getPreviousPage());

        var resource = new Resource(result.getSecond(), metaData);

        return ResponseEntity.ok(resource);
    }

    @GetMapping("/details")
    public ResponseEntity<Resource> getProductDetailById(
            @RequestParam(name = "id") Long id
    ) {
        var productDetail = productDetailService.getProductDetailWebById(id);
        return ResponseEntity.ok(new Resource(productDetail));
    }

}