package vn.edu.hust.project.appledeviceservice.enitity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderEntity extends BaseEntity{
    private Long userId;
    private String code;
    private String state;
    private String paymentMethod;
    private String paymentState;
    private Long totalPrice;
    private Long shippingInfoId;
    List<OrderLineEntity> orderLines;
    private Long createdAt;
    private Long updatedAt;
    private ShippingInfoEntity shippingInfo;
}
