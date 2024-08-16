package vn.edu.hust.project.appledeviceservice.repository.mysql;

import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequestWeb;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductDetailModel;

import java.util.List;

public interface ICustomProductDetailRepository {
    List<ProductDetailModel> getAllProductDetails(
            GetProductDetailRequestWeb filter
    );
}
