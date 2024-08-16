package vn.edu.hust.project.appledeviceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateStorageRequest;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;

@Mapper
public abstract class StorageResourceMapper {
    public static final StorageResourceMapper INSTANCE = Mappers.getMapper(StorageResourceMapper.class);

    public abstract StorageEntity toStorageEntityFromRequest(CreateStorageRequest request);


}
