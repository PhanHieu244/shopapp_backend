package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.port.IBlogPort;
@Service
@RequiredArgsConstructor
public class DeleteBlogUseCase {
    private final IBlogPort blogPort;

    public void deleteBlog(Long id) {
        blogPort.deleteBlog(id);
    }
}
