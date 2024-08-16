package com.project.shopapp.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
public class ProductEntity extends BaseEntity {

    private String name;

    private String code;

    private String description;

    private String bannerImg;

    private String status;

    private Long warrantyDuration;

    private Long typeId;

    private List<ImageEntity> descriptionImages;

    private List<ImageEntity> images;
}
