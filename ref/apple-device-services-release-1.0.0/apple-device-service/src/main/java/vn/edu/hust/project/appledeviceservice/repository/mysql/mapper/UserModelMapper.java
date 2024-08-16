package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.UserModel;

import java.util.List;

@Mapper
public abstract class UserModelMapper {
    public static final UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    public abstract UserModel toModel(UserEntity entity);

    public abstract UserEntity toEntity(UserModel model);

    public abstract List<UserEntity> toEntities(List<UserModel> models);
}
