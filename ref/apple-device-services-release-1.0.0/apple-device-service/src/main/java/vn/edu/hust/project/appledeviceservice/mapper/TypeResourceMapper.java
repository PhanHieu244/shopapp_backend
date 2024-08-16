package vn.edu.hust.project.appledeviceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateTypeRequest;
import vn.edu.hust.project.appledeviceservice.enitity.TypeEntity;

@Mapper
public abstract class TypeResourceMapper {
    public static final TypeResourceMapper INSTANCE = Mappers.getMapper(TypeResourceMapper.class);

    public abstract TypeEntity fromRequest(CreateTypeRequest request);
}
