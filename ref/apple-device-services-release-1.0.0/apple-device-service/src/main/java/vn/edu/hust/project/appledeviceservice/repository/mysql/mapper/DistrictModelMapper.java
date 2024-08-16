package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.DistrictEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.DistrictModel;

@Mapper
public abstract class DistrictModelMapper {
    public static final DistrictModelMapper INSTANCE = Mappers.getMapper(DistrictModelMapper.class);

    public abstract DistrictModel toModel(DistrictEntity entity);

    public abstract DistrictEntity toEntity(DistrictModel model);
}
