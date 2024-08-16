package vn.edu.hust.project.appledeviceservice.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ShippingInfoEntity extends BaseEntity{
    private String gender;

    @JsonProperty("full_name")
    private String receivedName;

    @JsonProperty("phone_number")
    private String phone;
    private String address;
    private String wardCode;
    private String districtCode;
    private String provinceCode;
    private String note;
    private Long userId;
    private ProvinceEntity province;
    private DistrictEntity district;
    private WardEntity ward;
}
