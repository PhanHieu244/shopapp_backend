package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetStorageRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.exception.GetStorageException;
import vn.edu.hust.project.appledeviceservice.exception.RemoveStorageException;
import vn.edu.hust.project.appledeviceservice.port.IStoragePort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IStorageRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.StorageModelMapper;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.StorageModel;
import vn.edu.hust.project.appledeviceservice.repository.mysql.specification.StorageSpecification;
import vn.edu.hust.project.appledeviceservice.utils.PageInfoUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StorageAdapter implements IStoragePort {

    private final IStorageRepository storageRepository;

    @Override
    public StorageEntity save(StorageEntity storageEntity) {
        return StorageModelMapper.INSTANCE.toStorageEntity(
                storageRepository.save(StorageModelMapper.INSTANCE.toStorageModel(storageEntity))
        );
    }

    @Override
    public Pair<PageInfo, List<StorageEntity>> getAllStorage(GetStorageRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());

        Page<StorageModel> result = storageRepository.findAll(new StorageSpecification(filter), pageable);
        var pageInfo = PageInfoUtils.getPageInfoUtils(result);

        return Pair.of(pageInfo, StorageModelMapper.INSTANCE.toStorageEntities(result.getContent()));
    }

    @Override
    public StorageEntity getStorageById(Long id) {
        var model = storageRepository.findById(id);
        if (model.isPresent()) {
            return StorageModelMapper.INSTANCE.toStorageEntity(model.get());
        }
        throw new GetStorageException();
    }

    @Override
    public void deleteStorageById(Long id) {
        try {
            storageRepository.deleteById(id);
        } catch (Exception e) {
            log.error("[StorageAdapter] Error when delete storage with id: {}", id, e);
            throw new RemoveStorageException();
        }
    }

    @Override
    public List<StorageEntity> findByIds(List<Long> ids) {
        return StorageModelMapper.INSTANCE.toStorageEntities(storageRepository.findByIdIn(ids));
    }
}
