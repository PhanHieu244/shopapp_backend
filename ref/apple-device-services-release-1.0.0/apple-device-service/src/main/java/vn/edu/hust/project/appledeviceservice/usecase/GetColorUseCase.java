package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetColorRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IColorPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetColorUseCase {
    private final IColorPort colorPort;

    public Pair<PageInfo, List<ColorEntity>> getAllColors(GetColorRequest filter){
        return colorPort.getAllColors(filter);
    }

    public ColorEntity getColorById(Long id){
        return colorPort.getColorById(id);
    }

}
