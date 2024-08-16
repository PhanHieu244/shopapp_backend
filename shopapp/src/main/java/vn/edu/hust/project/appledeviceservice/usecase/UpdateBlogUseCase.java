package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.UpdateBlogRequest;
import vn.edu.hust.project.appledeviceservice.port.IBlogPort;

@Service
@RequiredArgsConstructor
public class UpdateBlogUseCase {
    private final GetBlogUseCase getBlogUseCase;
    private final IBlogPort blogPort;

    public BlogEntity updateBlog(Long id, UpdateBlogRequest request) {
        BlogEntity blogEntity = getBlogUseCase.getBlogById(id);
        blogEntity.setTitle(request.getTitle());
        blogEntity.setContent(request.getContent());
        blogEntity.setStatus(request.getStatus());
        blogEntity.setBannerImg(request.getBannerImg());
        return blogPort.save(blogEntity);
    }
}
