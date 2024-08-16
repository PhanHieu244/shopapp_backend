package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

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
