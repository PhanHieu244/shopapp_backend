package vn.edu.hust.project.appledeviceservice.enitity.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateShippingInfoRequest {
    private String gender;
    private String fullName;
    private String phoneNumber;
    private String address;
    private ProvinceRequest province;
    private DistrictRequest district;
    private WardRequest ward;
    private String note;
    private Long userId;
}
