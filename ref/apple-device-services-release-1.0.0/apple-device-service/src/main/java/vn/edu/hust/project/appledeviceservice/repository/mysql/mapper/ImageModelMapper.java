package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.ImageEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ImageModel;

import java.util.List;

@Mapper
public abstract class ImageModelMapper {

    public static final ImageModelMapper INSTANCE = Mappers.getMapper(ImageModelMapper.class);

    public abstract ImageModel toModel(ImageEntity entity);

    public abstract ImageEntity toEntity(ImageModel model);

    public abstract List<ImageModel> toModels(List<ImageEntity> entities);

    public abstract List<ImageEntity> toEntities(List<ImageModel> models);
}
