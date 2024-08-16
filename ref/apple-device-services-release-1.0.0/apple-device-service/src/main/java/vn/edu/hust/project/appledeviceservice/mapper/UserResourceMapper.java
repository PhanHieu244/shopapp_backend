package vn.edu.hust.project.appledeviceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserWebRequest;

@Mapper
public abstract class UserResourceMapper {
    public static final UserResourceMapper INSTANCE = Mappers.getMapper(UserResourceMapper.class);

    public abstract UserEntity fromRequestToEntity(CreateUserRequest userRequest);

    public abstract UserEntity fromRequestWebToEntity(CreateUserWebRequest userRequest);
}
