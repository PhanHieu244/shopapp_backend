package com.project.shopapp.entity.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateColorRequest {
    @Valid
    @NotNull(message = "Color name must not be null")
    private String name;
    private String code;
    private String description;
}
