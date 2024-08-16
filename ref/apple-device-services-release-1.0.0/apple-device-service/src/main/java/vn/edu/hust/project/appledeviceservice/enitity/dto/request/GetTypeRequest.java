package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTypeRequest extends BaseGetRequest {
    private String name;
}
