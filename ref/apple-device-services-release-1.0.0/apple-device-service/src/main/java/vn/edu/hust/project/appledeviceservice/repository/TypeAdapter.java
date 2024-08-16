package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.TypeEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetTypeRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.exception.GetTypeException;
import vn.edu.hust.project.appledeviceservice.exception.RemoveTypeException;
import vn.edu.hust.project.appledeviceservice.port.ITypePort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.ITypeRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.TypeModelMapper;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.TypeModel;
import vn.edu.hust.project.appledeviceservice.repository.mysql.specification.TypeSpecification;
import vn.edu.hust.project.appledeviceservice.utils.PageInfoUtils;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class TypeAdapter implements ITypePort {

    private final ITypeRepository typeRepository;


    @Override
    public TypeEntity save(TypeEntity entity) {
        return TypeModelMapper.INSTANCE.toEntity(typeRepository.save(
                TypeModelMapper.INSTANCE.toModel(entity)
        ));
    }

    @Override
    public Pair<PageInfo, List<TypeEntity>> getAllTypes(GetTypeRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());
        Page<TypeModel> result = typeRepository.findAll(new TypeSpecification(filter), pageable);

        var pageInfo = PageInfoUtils.getPageInfoUtils(result);
        return Pair.of(pageInfo, TypeModelMapper.INSTANCE.toEntityList(result.getContent()));
    }

    @Override
    public TypeEntity getTypeById(Long id) {
        var type = typeRepository.findById(id);
        if (type.isPresent()) {
            return TypeModelMapper.INSTANCE.toEntity(type.get());
        }

        throw new GetTypeException();

    }

    @Override
    public void deleteTypeById(Long id) {
        try {
            typeRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error when delete type by id: {}", id);
            throw new RemoveTypeException();
        }
    }
}
