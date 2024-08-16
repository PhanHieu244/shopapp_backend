package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.InventoryModel;

@Mapper
public abstract class InventoryModelMapper {
    public static final InventoryModelMapper INSTANCE = Mappers.getMapper(InventoryModelMapper.class);

    public abstract InventoryModel toModel(InventoryEntity entity);

    public abstract InventoryEntity toEntity(InventoryModel model);

    public abstract List<InventoryEntity> toEntities(List<InventoryModel> models);
}
