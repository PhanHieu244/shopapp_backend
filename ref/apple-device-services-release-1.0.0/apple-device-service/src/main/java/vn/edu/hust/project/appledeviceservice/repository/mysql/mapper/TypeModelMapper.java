package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.TypeEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.TypeModel;

import java.util.List;

@Mapper
public abstract class TypeModelMapper {
    public static final TypeModelMapper INSTANCE = Mappers.getMapper(TypeModelMapper.class);

    public abstract TypeModel toModel(TypeEntity typeEntity);

    public abstract TypeEntity toEntity(TypeModel typeModel);

    public abstract List<TypeEntity> toEntityList(List<TypeModel> typeModels);
}
