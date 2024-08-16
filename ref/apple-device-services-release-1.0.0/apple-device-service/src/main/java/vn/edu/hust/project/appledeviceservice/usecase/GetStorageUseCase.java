package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetStorageRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IStoragePort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetStorageUseCase {
    private final IStoragePort storagePort;

    public Pair<PageInfo, List<StorageEntity>> getAllStorages(GetStorageRequest filter){
        return storagePort.getAllStorage(filter);
    }

    public StorageEntity getStorageById(Long id){
        return storagePort.getStorageById(id);
    }
}
