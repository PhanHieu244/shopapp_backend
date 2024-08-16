package vn.edu.hust.project.appledeviceservice.usecase;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateColorException;
import vn.edu.hust.project.appledeviceservice.port.IColorPort;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateColorUseCase {
    private final IColorPort colorPort;

    public ColorEntity createColor(ColorEntity color){
        try{
            return colorPort.save(color);
        } catch (Exception ex){
            log.error("[CreateColorUseCase] Error saving color, exception: " + ex.getMessage());
            throw new CreateColorException();
        }
    }
}
