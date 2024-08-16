package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.exception.CreateProductException;
import vn.edu.hust.project.appledeviceservice.exception.GetProductException;
import vn.edu.hust.project.appledeviceservice.port.IProductPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IProductRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.ProductModelMapper;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductModel;
import vn.edu.hust.project.appledeviceservice.repository.mysql.specification.ProductSpecification;
import vn.edu.hust.project.appledeviceservice.utils.PageInfoUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductAdapter implements IProductPort {

    private final IProductRepository productRepository;

    @Override
    public ProductEntity save(ProductEntity entity) {
        try {
            return ProductModelMapper.INSTANCE.toEntity(
                    productRepository.save(ProductModelMapper.INSTANCE.toModel(entity))
            );
        } catch (Exception ex){
            log.error("[IProductAdapter] Failed to save product, error: " + ex.getMessage());
            throw new CreateProductException();
        }

    }

    @Override
    public Pair<PageInfo, List<ProductEntity>> getAllProducts(GetProductRequest filter) {

        Pageable pageable = PageRequest.of(Math.toIntExact(filter.getPage()), Math.toIntExact(filter.getPageSize()),
                Sort.by("id").descending());

        Page<ProductModel> result = productRepository.findAll(new ProductSpecification(filter), pageable);

        var pageInfo = PageInfoUtils.getPageInfoUtils(result);

        return Pair.of(pageInfo, ProductModelMapper.INSTANCE.toEntities(result.getContent()));
    }

    @Override
    public ProductEntity getProductById(Long id) {
        return ProductModelMapper.INSTANCE.toEntity(
                productRepository.findById(id).orElseThrow(GetProductException::new)
        );
    }

    @Override
    public List<ProductEntity> getProductByIds(List<Long> ids) {
        return ProductModelMapper.INSTANCE.toEntities(
                productRepository.findByIdIn(ids)
        );
    }
}
