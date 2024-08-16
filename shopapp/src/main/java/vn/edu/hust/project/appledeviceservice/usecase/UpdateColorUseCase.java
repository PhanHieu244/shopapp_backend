package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.port.IColorPort;

@Service
@RequiredArgsConstructor
public class UpdateColorUseCase {

    private final IColorPort colorPort;

    public ColorEntity updateColor(ColorEntity entity){
        return colorPort.save(entity);
    }
}
