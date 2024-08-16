package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetProductRequest extends BaseGetRequest {
    private String name;
}
