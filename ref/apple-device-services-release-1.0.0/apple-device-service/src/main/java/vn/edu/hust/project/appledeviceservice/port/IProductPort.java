package vn.edu.hust.project.appledeviceservice.port;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;

public interface IProductPort {
    ProductEntity save(ProductEntity entity);

    Pair<PageInfo, List<ProductEntity>> getAllProducts(GetProductRequest request);

    ProductEntity getProductById(Long id);

    List<ProductEntity> getProductByIds(List<Long> ids);

}
