package com.project.shopapp.entity.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTypeRequest {
    @NotNull(message = "name of type not null")
    private String name;

    @NotNull(message = "code of type not null")
    private String code;
}
