package vn.edu.hust.project.appledeviceservice.service;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequestWeb;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.ProductDetailWebResponse;

@Service
public interface IProductDetailService {
    ProductDetailEntity createProductDetail(CreateProductDetailRequest request);

    Pair<PageInfo, List<ProductDetailEntity>> getAllProductDetails(GetProductDetailRequest filter);

    ProductDetailEntity getProductDetail(Long productId);

    Pair<PageInfo, List<ProductDetailEntity>> getAllProductDetailsWeb(
            GetProductDetailRequestWeb filter
    );

    ProductDetailWebResponse getProductDetailWebById(Long id);
}
