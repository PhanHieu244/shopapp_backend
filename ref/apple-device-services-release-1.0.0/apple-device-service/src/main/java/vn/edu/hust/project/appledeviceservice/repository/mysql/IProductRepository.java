package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductModel;

import java.util.List;

@Repository
public interface IProductRepository extends IBaseRepository<ProductModel>{
    List<ProductModel> findByIdIn(List<Long> ids);
}
