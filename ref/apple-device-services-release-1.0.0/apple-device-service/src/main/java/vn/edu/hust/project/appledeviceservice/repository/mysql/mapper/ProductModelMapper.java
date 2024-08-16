package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductModel;

import java.util.List;

@Mapper
public abstract class ProductModelMapper {

    public static final ProductModelMapper INSTANCE = Mappers.getMapper(ProductModelMapper.class);

    public abstract ProductModel toModel(ProductEntity entity);

    public abstract ProductEntity toEntity(ProductModel model);

    public abstract List<ProductEntity> toEntities(List<ProductModel> models);
}
