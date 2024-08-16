package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequestWeb;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.ProductDetailWebResponse;
import vn.edu.hust.project.appledeviceservice.service.IProductDetailService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateProductDetailUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.GetListProductDetailWebUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.GetProductDetailUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDetailService implements IProductDetailService {

    private final CreateProductDetailUseCase createProductDetailUseCase;

    private final GetProductDetailUseCase getProductDetailUseCase;

    private final GetListProductDetailWebUseCase getListProductDetailWebUseCase;

    @Override
    public ProductDetailEntity createProductDetail(CreateProductDetailRequest request) {
        return createProductDetailUseCase.createProductDetail(request);
    }

    @Override
    public Pair<PageInfo, List<ProductDetailEntity>> getAllProductDetails(GetProductDetailRequest filter) {
        return getProductDetailUseCase.getAllProductDetails(filter);
    }

    @Override
    public ProductDetailEntity getProductDetail(Long productId) {
        return getProductDetailUseCase.getProductDetail(productId);
    }

    @Override
    public Pair<PageInfo, List<ProductDetailEntity>> getAllProductDetailsWeb(GetProductDetailRequestWeb filter) {
        return getListProductDetailWebUseCase.getAllProductDetailsWeb(filter);
    }

    @Override
    public ProductDetailWebResponse getProductDetailWebById(Long id) {
        return getListProductDetailWebUseCase.getProductDetailWebById(id);
    }
}
