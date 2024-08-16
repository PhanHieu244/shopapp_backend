package com.project.shopapp.entity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTypeRequest extends BaseGetRequest {
    private String name;
}
