package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.BlogEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.BlogModel;

import java.util.List;

@Mapper
public abstract class BlogModelMapper {
    public static final BlogModelMapper INSTANCE =  Mappers.getMapper(BlogModelMapper.class);

    public abstract BlogModel toModel(BlogEntity entity);
    @Mapping(target = "id", source = "id")
    public abstract BlogEntity toEntity(BlogModel model);

    public abstract List<BlogEntity> toEntities(List<BlogModel> models);

}
