package com.project.shopapp.entity.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.project.shopapp.entity.ColorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RelatedColorWebResponse {
    private Long productDetailId;
    private String bannerImg;
    private ColorEntity color;
    private Long unitPrice;
    private Long price;
    private InventoryWebResponse inventory;
}
