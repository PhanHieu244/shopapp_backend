package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.StorageModel;

import java.util.List;

@Mapper
public abstract class StorageModelMapper {
    public static final StorageModelMapper INSTANCE = Mappers.getMapper(StorageModelMapper.class);

    public abstract StorageModel toStorageModel(StorageEntity storageEntity);

    public abstract StorageEntity toStorageEntity(StorageModel storageModel);

    public abstract List<StorageEntity>  toStorageEntities(List<StorageModel> models);
}
