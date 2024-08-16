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
@Entity(name="Inventory Model")
@Table(name = "inventories")
public class InventoryModel extends BaseModel {

    @Column(name = "product_detail_id")
    private Long productDetailId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "sold")
    private Long sold;

    @Column(name = "available")
    private Long available;
}
