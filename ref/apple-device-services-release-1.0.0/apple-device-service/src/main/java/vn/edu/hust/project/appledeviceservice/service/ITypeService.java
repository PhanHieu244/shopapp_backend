package vn.edu.hust.project.appledeviceservice.service;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.TypeEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetTypeRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;

public interface ITypeService {
    TypeEntity createType(TypeEntity entity);

    Pair<PageInfo, List<TypeEntity>> getAllTypes(GetTypeRequest filter);

    TypeEntity getTypeById(Long id);

    void deleteTypeById(Long id);
}
