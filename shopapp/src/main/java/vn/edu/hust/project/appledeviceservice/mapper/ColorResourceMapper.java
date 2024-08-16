package vn.edu.hust.project.appledeviceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateColorRequest;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;

@Mapper
public abstract class ColorResourceMapper {
    public static final ColorResourceMapper INSTANCE = Mappers.getMapper(ColorResourceMapper.class);

    public abstract ColorEntity toEntity(CreateColorRequest request);

}
