package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.constant.BlogStatus;
import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IBlogPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBlogUseCase {
    private final IBlogPort blogPort;

    public Pair<PageInfo, List<BlogEntity>> getAllBlogs(GetBlogRequest filter) {
        var result = blogPort.getAllBlogs(filter);
        var blogs = result.getSecond();
        blogs = blogs.stream().filter(blog -> !BlogStatus.DELETED.name().equalsIgnoreCase(blog.getStatus())).toList();
        return Pair.of(result.getFirst(), blogs);
    }

    public BlogEntity getBlogById(Long id) {
        return blogPort.getBlogById(id);
    }

    public Pair<PageInfo, List<BlogEntity>> getAllWebBlogs(GetBlogRequest filter) {
        var result = blogPort.getAllBlogs(filter);
        var blogs = result.getSecond();
        blogs = blogs.stream().filter(blog -> !BlogStatus.DELETED.name().equalsIgnoreCase(blog.getStatus())).toList();
        return Pair.of(result.getFirst(), blogs);
    }

}
