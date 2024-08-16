package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateColorRequest {
    @NotNull(message = "Color name must not be null")
    private String name;

    private String description;
}
