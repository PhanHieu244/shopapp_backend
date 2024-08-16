package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.service.IProductService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateProductUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.GetProductUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final CreateProductUseCase createProductUseCase;

    private final GetProductUseCase getProductUseCase;

    @Override
    public ProductEntity createProduct(CreateProductRequest request) {
        return createProductUseCase.createProduct(request);
    }

    @Override
    public Pair<PageInfo, List<ProductEntity>> getAllProducts(GetProductRequest filter) {
        return getProductUseCase.getAllProducts(filter);
    }

    @Override
    public ProductEntity getProductDetail(Long id) {
        return getProductUseCase.getProductDetail(id);
    }


}
