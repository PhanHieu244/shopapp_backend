package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductDetailModel;

import java.util.List;


@Mapper
public abstract class ProductDetailModelMapper {
    public static final ProductDetailModelMapper INSTANCE = Mappers.getMapper(ProductDetailModelMapper.class);

    public abstract ProductDetailModel toModel(ProductDetailEntity entity);

    public abstract ProductDetailEntity toEntity(ProductDetailModel model);

    public abstract List<ProductDetailEntity> toEntities(List<ProductDetailModel> models);
}
