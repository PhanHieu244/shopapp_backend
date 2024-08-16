package vn.edu.hust.project.appledeviceservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.ProductDetailWebResponse;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.RelatedColorWebResponse;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.RelatedStorageResponse;

import java.util.List;

@Mapper
public abstract class ProductDetailResourceMapper {
    public static final ProductDetailResourceMapper INSTANCE = Mappers.getMapper(ProductDetailResourceMapper.class);

    @Mapping(target = "images", ignore = true)
    public abstract ProductDetailEntity toEntityFromRequest(CreateProductDetailRequest request);

    public abstract ProductDetailWebResponse toWebResponse(ProductDetailEntity productDetailEntity);

    @Mapping(target = "productDetailId", source = "id")
    public abstract RelatedColorWebResponse toRelatedColorWebResponse(ProductDetailEntity productDetailEntity);

    @Mapping(target = "productDetailId", source = "id")
    public abstract RelatedStorageResponse toRelatedStorageWebResponse(ProductDetailEntity productDetailEntity);

    public abstract List<RelatedColorWebResponse>
    toRelatedColorWebResponseList(List<ProductDetailEntity> productDetailEntities);

    public abstract List<RelatedStorageResponse> toRelatedStorageWebResponseList(List<ProductDetailEntity> productDetailEntities);
}
