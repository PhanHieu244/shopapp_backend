package com.project.shopapp.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WarrantyEntity {
    private ProductDetailEntity productDetail;
    private String orderCode;
    private Long warrantyDuration;
    private String warrantyStatus;
    private Long warrantyDateTo;
}
