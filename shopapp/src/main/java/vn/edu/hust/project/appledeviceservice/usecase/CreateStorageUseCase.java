package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;
import vn.edu.hust.project.appledeviceservice.port.IStoragePort;

@Service
@RequiredArgsConstructor
public class CreateStorageUseCase {
    private final IStoragePort storagePort;

    public StorageEntity createStorage(StorageEntity storageEntity){
        return storagePort.save(storageEntity);
    }


}
