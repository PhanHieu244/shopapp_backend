package com.project.shopapp.entity.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.project.shopapp.entity.ImageEntity;
import com.project.shopapp.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDetailWebResponse {
    private Long id;
    private String name;
    private String bannerImg;
    private Long productId;
    private  Long colorId;
    private Long storageId;
    private Long unitPrice;
    private Long price;

    private List<ImageEntity> images;
    private ProductEntity product;

    private List<RelatedColorWebResponse> relatedColors;
    private List<RelatedStorageResponse> relatedStorages;

}
