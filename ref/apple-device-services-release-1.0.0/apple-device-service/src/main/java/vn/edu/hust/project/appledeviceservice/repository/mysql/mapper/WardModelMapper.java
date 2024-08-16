package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.WardEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.WardModel;

@Mapper
public abstract class WardModelMapper {
    public static final WardModelMapper INSTANCE = Mappers.getMapper(WardModelMapper.class);

    public abstract WardModel toModel(WardEntity entity);

    public abstract WardEntity toEntity(WardModel model);
}
