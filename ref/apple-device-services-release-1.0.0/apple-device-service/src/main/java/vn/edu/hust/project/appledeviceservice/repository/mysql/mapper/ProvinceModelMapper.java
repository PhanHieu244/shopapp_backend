package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.ProvinceEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProvinceModel;

@Mapper
public abstract class ProvinceModelMapper {
    public static final ProvinceModelMapper INSTANCE = Mappers.getMapper(ProvinceModelMapper.class);

    public abstract ProvinceModel toModel(ProvinceEntity entity);

    public abstract ProvinceEntity toEntity(ProvinceModel model);


}
