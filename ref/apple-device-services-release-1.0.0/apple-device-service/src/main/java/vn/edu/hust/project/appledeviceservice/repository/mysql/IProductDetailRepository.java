package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductDetailModel;

import java.util.List;

@Repository
public interface IProductDetailRepository extends IBaseRepository<ProductDetailModel> {
    List<ProductDetailModel> findByProductIdAndStorageId(Long productId, Long storageId);

    List<ProductDetailModel> findByProductId(Long productId);

    List<ProductDetailModel> findByIdIn(List<Long> ids);
}
