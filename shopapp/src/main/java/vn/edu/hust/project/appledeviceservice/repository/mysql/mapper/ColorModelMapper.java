package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ColorModel;

import java.util.List;

@Mapper
public abstract class ColorModelMapper {
    public static final ColorModelMapper INSTANCE = Mappers.getMapper(ColorModelMapper.class);

    public abstract ColorModel toModel(ColorEntity colorEntity);

    public abstract ColorEntity toEntity(ColorModel colorModel);

    public abstract List<ColorEntity> toEntities(List<ColorModel> colorModelList);
}
