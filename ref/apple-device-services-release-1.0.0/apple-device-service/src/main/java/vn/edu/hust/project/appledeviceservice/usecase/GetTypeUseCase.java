package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.TypeEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetTypeRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.ITypePort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTypeUseCase {
    private final ITypePort typePort;

    public Pair<PageInfo, List<TypeEntity>> getAllTypes(GetTypeRequest filter){
        return typePort.getAllTypes(filter);
    }

    public TypeEntity getTypeById(Long id){
        return typePort.getTypeById(id);
    }
}
