package vn.edu.hust.project.appledeviceservice.repository.mysql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "OrderLine Model")
@Table(name = "order_lines")
public class OrderLineModel extends BaseModel {

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "code")
    private String code;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "product_detail_id")
    private Long productDetailId;
}
