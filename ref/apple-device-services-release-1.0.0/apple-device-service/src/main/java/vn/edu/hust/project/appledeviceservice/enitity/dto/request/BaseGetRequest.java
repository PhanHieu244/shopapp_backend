package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseGetRequest {
    private Long page;

    private Long pageSize;
}
