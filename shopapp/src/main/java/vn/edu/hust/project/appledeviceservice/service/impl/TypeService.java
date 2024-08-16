package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.hust.project.appledeviceservice.enitity.TypeEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetTypeRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.service.ITypeService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateTypeUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.GetTypeUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.RemoveTypeUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService implements ITypeService {

    private final CreateTypeUseCase createTypeUseCase;

    private final GetTypeUseCase getTypeUseCase;

    private final RemoveTypeUseCase removeTypeUseCase;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TypeEntity createType(TypeEntity entity) {
        return createTypeUseCase.createType(entity);
    }

    @Override
    public Pair<PageInfo, List<TypeEntity>> getAllTypes(GetTypeRequest filter) {
        return getTypeUseCase.getAllTypes(filter);
    }

    @Override
    public TypeEntity getTypeById(Long id) {
        return getTypeUseCase.getTypeById(id);
    }

    @Override
    public void deleteTypeById(Long id) {
        removeTypeUseCase.removeTypeById(id);
    }
}
