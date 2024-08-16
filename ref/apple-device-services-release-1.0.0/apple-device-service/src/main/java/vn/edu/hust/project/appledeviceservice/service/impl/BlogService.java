package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.UpdateBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.service.IBlogService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateBlogUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.DeleteBlogUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.GetBlogUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.UpdateBlogUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService implements IBlogService {
    private final CreateBlogUseCase createBlogUseCase;
    private final GetBlogUseCase getBlogUseCase;
    private final UpdateBlogUseCase updateBlogUseCase;
    private final DeleteBlogUseCase deleteBlogUseCase;
    @Override
    public BlogEntity createBlog(CreateBlogRequest request, Long userId) {
        return createBlogUseCase.createBlog(request, userId);
    }

    @Override
    public Pair<PageInfo, List<BlogEntity>> getAllBlogs(GetBlogRequest request) {
        return getBlogUseCase.getAllBlogs(request);
    }

    @Override
    public BlogEntity updateBlog(Long id, UpdateBlogRequest request) {
        return updateBlogUseCase.updateBlog(id, request);
    }

    @Override
    public void deleteBlog(Long id) {
        deleteBlogUseCase.deleteBlog(id);
    }

    @Override
    public Pair<PageInfo, List<BlogEntity>> getAllBlogsWeb(GetBlogRequest request) {
        return getBlogUseCase.getAllWebBlogs(request);
    }

    @Override
    public BlogEntity getBlogById(Long id) {
        return getBlogUseCase.getBlogById(id);
    }
}
