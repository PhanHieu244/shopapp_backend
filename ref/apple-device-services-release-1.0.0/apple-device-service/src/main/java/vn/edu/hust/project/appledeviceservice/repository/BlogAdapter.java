package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetBlogRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.exception.CreateBlogException;
import vn.edu.hust.project.appledeviceservice.exception.GetBlogException;
import vn.edu.hust.project.appledeviceservice.port.IBlogPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IBlogRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.BlogModelMapper;
import vn.edu.hust.project.appledeviceservice.repository.mysql.specification.BlogSpecification;
import vn.edu.hust.project.appledeviceservice.utils.PageInfoUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogAdapter implements IBlogPort {
    private final IBlogRepository blogRepository;


    @Override
    public BlogEntity save(BlogEntity entity) {
        try {
            var savedModel = blogRepository.save(BlogModelMapper.INSTANCE.toModel(entity));
            return BlogModelMapper.INSTANCE.toEntity(savedModel);
        } catch (Exception e) {
            log.error("[BlogAdapter] Create blog fail, err: " + e.getMessage());
            throw new CreateBlogException();
        }

    }

    @Override
    public Pair<PageInfo, List<BlogEntity>> getAllBlogs(GetBlogRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());
        var result = blogRepository.findAll(new BlogSpecification(filter), pageable);
        var pageInfo = PageInfoUtils.getPageInfoUtils(result);
        return Pair.of(pageInfo, BlogModelMapper.INSTANCE.toEntities(result.getContent()));
    }

    @Override
    public BlogEntity getBlogById(Long id) {
        return BlogModelMapper.INSTANCE.toEntity(blogRepository.findById(id).orElseThrow(
                () -> {
                    log.error("[BlogAdapter] Blog not found, id: " + id);
                    return new GetBlogException();
                }
        ));
    }

    @Override
    public void deleteBlog(Long id) {
        try {
            blogRepository.deleteById(id);
        } catch (Exception e) {
            log.error("[BlogAdapter] Delete blog fail, err: " + e.getMessage());
            throw new GetBlogException();
        }
    }
}
