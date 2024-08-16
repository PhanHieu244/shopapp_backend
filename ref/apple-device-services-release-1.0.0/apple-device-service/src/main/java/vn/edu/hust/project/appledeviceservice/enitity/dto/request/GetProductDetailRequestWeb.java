package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import lombok.Getter;
import lombok.Setter;
import vn.edu.hust.project.appledeviceservice.enitity.BaseEntity;
@Getter
@Setter
public class GetProductDetailRequestWeb extends BaseEntity {
    private String type;
    private String category;
    private String status;
    private Long page;
    private Long pageSize;
}
