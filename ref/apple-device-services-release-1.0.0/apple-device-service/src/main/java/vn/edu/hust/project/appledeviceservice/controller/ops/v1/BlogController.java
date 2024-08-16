package vn.edu.hust.project.appledeviceservice.controller.ops.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetColorRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.UpdateBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.MetaDataWithTotalRecord;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;
import vn.edu.hust.project.appledeviceservice.service.IBlogService;
import vn.edu.hust.project.appledeviceservice.service.IUserSecurityService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ops/api/v1/blogs")
public class BlogController {

    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";

    private final IBlogService blogService;
    private final IUserSecurityService userSecurityService;

    @PostMapping
    public ResponseEntity<Resource> createBlog(
            @RequestBody CreateBlogRequest request
    ) {
        var userId = userSecurityService.getUserId();
        return ResponseEntity.ok(new Resource(blogService.createBlog(request, userId)));
    }

    @GetMapping
    public ResponseEntity<Resource> getAll(
            @RequestParam(defaultValue = DEFAULT_PAGE, name = "page") Long page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE, name = "page_size") Long pageSize
    ) {
        var filter = new GetBlogRequest();

        filter.setPage(page);
        filter.setPageSize(pageSize);

        var result = blogService.getAllBlogs(filter);

        var pageInfo = result.getFirst();

        var metaData = new MetaDataWithTotalRecord(pageInfo.getTotalRecord(), pageInfo.getPageSize(),
                pageInfo.getTotalPage(), pageInfo.getNextPage(), pageInfo.getPreviousPage());

        var resource = new Resource(result.getSecond(), metaData);

        return ResponseEntity.ok(resource);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Resource> updateBlog(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateBlogRequest request
    ) {
        return ResponseEntity.ok(new Resource(blogService.updateBlog(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Resource> deleteBlog(
            @PathVariable(name = "id") Long id
    ) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok(new Resource(null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getBlogById(
            @PathVariable(name = "id") Long id
    ) {
        return ResponseEntity.ok(new Resource(blogService.getBlogById(id)));
    }
}
