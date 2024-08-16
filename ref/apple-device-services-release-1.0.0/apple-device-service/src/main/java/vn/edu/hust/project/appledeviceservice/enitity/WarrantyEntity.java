package vn.edu.hust.project.appledeviceservice.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WarrantyEntity {
    private ProductDetailEntity productDetail;
    private String orderCode;
    private Long warrantyDuration;
    private String warrantyStatus;
    private Long warrantyDateTo;
}
