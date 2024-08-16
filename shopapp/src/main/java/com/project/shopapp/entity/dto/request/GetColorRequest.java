package com.project.shopapp.entity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetColorRequest extends BaseGetRequest {
    private String name;
}
