package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.RoleEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.RoleModel;

@Mapper
public abstract class RoleModelMapper {

    public static final RoleModelMapper INSTANCE = Mappers.getMapper(RoleModelMapper.class);

    public abstract RoleModel toRoleModel(RoleEntity entity);

    public abstract RoleEntity toRoleEntity(RoleModel model);
}
