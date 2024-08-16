package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetStorageRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.service.IStorageService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateStorageUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.GetStorageUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.RemoveStorageUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorageService implements IStorageService {

    private final CreateStorageUseCase createStorageUseCase;

    private final GetStorageUseCase getStorageUseCase;

    private final RemoveStorageUseCase removeStorageUseCase;

    @Override
    public StorageEntity createStorage(StorageEntity storageEntity) {
        return createStorageUseCase.createStorage(storageEntity);
    }

    @Override
    public Pair<PageInfo, List<StorageEntity>> getAllStorage(GetStorageRequest filter) {
        return getStorageUseCase.getAllStorages(filter);
    }

    @Override
    public StorageEntity getStorageById(Long id) {
        return getStorageUseCase.getStorageById(id);
    }

    @Override
    public void deleteStorageById(Long id) {
        removeStorageUseCase.removeStorageId(id);
    }
}
