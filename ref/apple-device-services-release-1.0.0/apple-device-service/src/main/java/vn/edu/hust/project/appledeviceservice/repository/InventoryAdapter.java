package vn.edu.hust.project.appledeviceservice.repository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetInventoryRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.exception.CreateInventoryException;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IInventoryRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.InventoryModelMapper;
import vn.edu.hust.project.appledeviceservice.port.IInventoryPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.InventoryModel;
import vn.edu.hust.project.appledeviceservice.repository.mysql.specification.InventorySpecification;
import vn.edu.hust.project.appledeviceservice.utils.PageInfoUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryAdapter implements IInventoryPort {

    private final IInventoryRepository inventoryRepository;

    @Override
    public InventoryEntity save(InventoryEntity entity) {
        try {
            return InventoryModelMapper.INSTANCE.toEntity(
                    inventoryRepository.save(
                            InventoryModelMapper.INSTANCE.toModel(entity)
                    )
            );
        } catch (Exception e) {
            log.error("[InventoryAdapter] Create inventory fail, err: " + e.getMessage());
            throw new CreateInventoryException();
        }
    }

    @Override
    public Pair<PageInfo, List<InventoryEntity>> getAllInventory(GetInventoryRequest filter) {
        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());
        Page<InventoryModel> result = inventoryRepository.findAll(new InventorySpecification(filter), pageable);

        var pageInfo = PageInfoUtils.getPageInfoUtils(result);

        return Pair.of(pageInfo, InventoryModelMapper.INSTANCE.toEntities(result.getContent()));
    }

    @Override
    public List<InventoryEntity> getInventoryByProductDetailIds(List<Long> productDetailIds) {
        return InventoryModelMapper.INSTANCE.toEntities(inventoryRepository.findByProductDetailIdIn(productDetailIds));
    }

    @Override
    public InventoryEntity getInventoryByProductDetailId(Long productDetailId) {
        return InventoryModelMapper.INSTANCE.
                toEntity(inventoryRepository.findByProductDetailId(productDetailId).orElse(null));
    }


}
