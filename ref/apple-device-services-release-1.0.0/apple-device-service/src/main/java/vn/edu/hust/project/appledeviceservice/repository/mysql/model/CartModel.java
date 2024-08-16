package vn.edu.hust.project.appledeviceservice.repository.mysql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Cart Model")
@Table(name = "carts")
public class CartModel extends BaseModel {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_detail_id")
    private Long productDetailId;

    @Column(name = "quantity")
    private Long quantity;
}
