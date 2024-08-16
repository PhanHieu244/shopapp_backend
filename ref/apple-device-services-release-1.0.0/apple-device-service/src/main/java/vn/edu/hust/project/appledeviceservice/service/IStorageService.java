package vn.edu.hust.project.appledeviceservice.service;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetStorageRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;

public interface IStorageService {
    StorageEntity createStorage(StorageEntity storageEntity);

    Pair<PageInfo, List<StorageEntity>> getAllStorage(GetStorageRequest filter);

    StorageEntity getStorageById(Long id);

    void deleteStorageById(Long id);
}
