package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.port.IColorPort;

@Service
@RequiredArgsConstructor
public class RemoveColorUseCase {
    private final IColorPort colorPort;

    public void removeColorById(Long colorId) {
        colorPort.deleteColorById(colorId);
    }
}
