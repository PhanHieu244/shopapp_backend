package com.project.shopapp.entity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetStorageRequest extends BaseGetRequest {
    private Long volume;
}
