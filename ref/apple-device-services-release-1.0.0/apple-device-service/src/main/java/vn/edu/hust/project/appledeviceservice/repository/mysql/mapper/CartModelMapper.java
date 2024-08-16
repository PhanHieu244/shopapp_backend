package vn.edu.hust.project.appledeviceservice.repository.mysql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.CartModel;

import java.util.List;

@Mapper
public abstract class CartModelMapper {
    public static final CartModelMapper INSTANCE = Mappers.getMapper(CartModelMapper.class);
    @Mapping(target="productDetailId", source="productDetailId")
    public abstract CartModel toModel(CartEntity entity);

    public abstract CartEntity toEntity(CartModel model);

    public abstract List<CartEntity> toEntities(List<CartModel> models);
}
