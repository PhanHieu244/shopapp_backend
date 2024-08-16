package vn.edu.hust.project.appledeviceservice.service;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetColorRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;

public interface IColorService {
    ColorEntity createColorEntity(ColorEntity colorEntity);

    Pair<PageInfo, List<ColorEntity>> getAllColors(GetColorRequest filter);

    ColorEntity getColorById(Long id);

    void deleteColorById(Long id);

    ColorEntity updateColorEntity(ColorEntity colorEntity);
}
