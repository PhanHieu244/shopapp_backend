package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDetailRequest extends BaseGetRequest{
    private String name;
}
