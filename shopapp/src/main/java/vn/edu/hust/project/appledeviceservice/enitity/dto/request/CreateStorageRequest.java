package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStorageRequest {
    @NotNull(message = "volume must be not null")
    private Long volume;

    @NotNull(message = "unit must be not null")
    private String unit;
}
