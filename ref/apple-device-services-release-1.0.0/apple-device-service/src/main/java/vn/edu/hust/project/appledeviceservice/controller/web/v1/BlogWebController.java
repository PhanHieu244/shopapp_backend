package vn.edu.hust.project.appledeviceservice.controller.web.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.constant.BlogStatus;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.MetaDataWithTotalRecord;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IBlogService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/web/api/v1/blogs")
public class BlogWebController {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private final IBlogService blogService;

    @GetMapping
    public ResponseEntity<Resource> getAll(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize
    )
    {
        var filter = new GetBlogRequest();

        filter.setPage(page);
        filter.setPageSize(pageSize);
        filter.setStatus(BlogStatus.PUBLISHED.name());

        var result = blogService.getAllBlogsWeb(filter);

        var pageInfo = result.getFirst();

        var metaData = new MetaDataWithTotalRecord(pageInfo.getTotalRecord(), pageInfo.getPageSize(),
                pageInfo.getTotalPage(), pageInfo.getNextPage(), pageInfo.getPreviousPage());

        var resource = new Resource(result.getSecond(), metaData);

        return ResponseEntity.ok(resource);

    }

    @GetMapping("/details")
    public ResponseEntity<Resource> getBlogById(
            @RequestParam(name = "id") Long id
    ) {
        return ResponseEntity.ok(new Resource(blogService.getBlogById(id)));
    }
}
