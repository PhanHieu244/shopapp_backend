package vn.edu.hust.project.appledeviceservice.port;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequestWeb;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;

public interface IProductDetailPort {
    ProductDetailEntity save(ProductDetailEntity entity);

    Pair<PageInfo, List<ProductDetailEntity>> getAllProductDetails(GetProductDetailRequest filter);

    ProductDetailEntity getProductDetail(Long id);

    Pair<PageInfo, List<ProductDetailEntity>> getAllProductDetailsWeb(GetProductDetailRequestWeb filter);

    List<ProductDetailEntity> getProductDetailsByProductIdAndStorageId(Long productId, Long storageId);

    List<ProductDetailEntity> getProductDetailsByProductId(Long productId);

    List<ProductDetailEntity> getProductDetailByIds(List<Long> ids);

}
