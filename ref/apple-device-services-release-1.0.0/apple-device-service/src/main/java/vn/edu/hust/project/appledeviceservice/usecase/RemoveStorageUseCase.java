package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.port.IStoragePort;

@Service
@RequiredArgsConstructor
public class RemoveStorageUseCase {
    private final IStoragePort storagePort;

    public void removeStorageId(Long id){
        storagePort.deleteStorageById(id);
    }
}
