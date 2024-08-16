package vn.edu.hust.project.appledeviceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateBlogRequest;

@Mapper
public abstract class BlogResourceMapper {
    public static final BlogResourceMapper INSTANCE = Mappers.getMapper(BlogResourceMapper.class);

    public abstract BlogEntity toEntityFromRequest(CreateBlogRequest request, Long userId);
}
