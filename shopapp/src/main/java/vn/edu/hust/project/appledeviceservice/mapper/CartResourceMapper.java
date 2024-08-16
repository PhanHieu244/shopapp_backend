package vn.edu.hust.project.appledeviceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateCartRequest;

@Mapper
public abstract class CartResourceMapper {
    public static final CartResourceMapper INSTANCE = Mappers.getMapper(CartResourceMapper.class);

    public abstract CartEntity toEntityFromRequest(CreateCartRequest request);
}
