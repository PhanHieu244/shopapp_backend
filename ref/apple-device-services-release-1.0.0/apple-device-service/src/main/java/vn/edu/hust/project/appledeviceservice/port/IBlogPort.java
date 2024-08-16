package vn.edu.hust.project.appledeviceservice.port;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;

public interface IBlogPort {
    BlogEntity save(BlogEntity entity);

    Pair<PageInfo, List<BlogEntity>> getAllBlogs(GetBlogRequest filter);

    BlogEntity getBlogById(Long id);

    void deleteBlog(Long id);
}
