package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.port.ITypePort;

@Service
@RequiredArgsConstructor
@Slf4j
public class RemoveTypeUseCase {
    private final ITypePort typePort;

    public void removeTypeById(Long id){
        typePort.deleteTypeById(id);
    }
}
