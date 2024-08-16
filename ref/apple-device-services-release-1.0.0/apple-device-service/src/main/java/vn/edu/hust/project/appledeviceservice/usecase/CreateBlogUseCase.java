package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateBlogRequest;
import vn.edu.hust.project.appledeviceservice.mapper.BlogResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.IBlogPort;

@Service
@RequiredArgsConstructor
public class CreateBlogUseCase {
    private final IBlogPort blogPort;

    public BlogEntity createBlog(CreateBlogRequest request, Long userId) {
        var blog = BlogResourceMapper.INSTANCE.toEntityFromRequest(request, userId);
        return blogPort.save(blog);
    }
}
