package vn.edu.hust.project.appledeviceservice.service;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.UpdateBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;

public interface IBlogService {
    BlogEntity createBlog(CreateBlogRequest request, Long userId);

    Pair<PageInfo, List<BlogEntity>> getAllBlogs(GetBlogRequest request);

    BlogEntity updateBlog(Long id, UpdateBlogRequest request);

    void deleteBlog(Long id);

    Pair<PageInfo, List<BlogEntity>> getAllBlogsWeb(GetBlogRequest request);

    BlogEntity getBlogById(Long id);
}
