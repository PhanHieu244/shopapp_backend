package com.project.shopapp.entity.dto.request;

import com.project.shopapp.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDetailRequestWeb extends BaseEntity {
    private String type;
    private String category;
    private String status;
    private Long page;
    private Long pageSize;
}
