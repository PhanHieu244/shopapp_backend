package vn.edu.hust.project.appledeviceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;

@Mapper
public abstract class ProductResourceMapper {
    public static final ProductResourceMapper INSTANCE = Mappers.getMapper(ProductResourceMapper.class);

    @Mapping(target = "descriptionImages", ignore = true)
    @Mapping(target = "images", ignore = true)
    public abstract ProductEntity toProductEntityFromRequest(CreateProductRequest request);
}
