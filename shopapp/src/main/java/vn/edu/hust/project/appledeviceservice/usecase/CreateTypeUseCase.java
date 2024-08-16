package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.TypeEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateTypeException;
import vn.edu.hust.project.appledeviceservice.port.ITypePort;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateTypeUseCase {
    private final ITypePort typePort;

    public TypeEntity createType(TypeEntity typeEntity) {
        try{
            return typePort.save(typeEntity);
        } catch (Exception e){
            log.error("[CreateTypeUseCase] Error saving type, exception: " + e.getMessage());
            throw new CreateTypeException();
        }
    }
}
