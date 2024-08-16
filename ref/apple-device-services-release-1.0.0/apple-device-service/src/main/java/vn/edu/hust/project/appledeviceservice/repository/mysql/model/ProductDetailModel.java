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
@Entity(name = "Product Details Model")
@Table(name = "product_details")
public class ProductDetailModel extends BaseModel{
    @Column(name = "name")
    private String name;

    @Column(name = "banner_img")
    private String bannerImg;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "color_id")
    private Long colorId;

    @Column(name = "storage_id")
    private Long storageId;

    @Column(name = "unit_price")
    private Long unitPrice;

    @Column(name = "price")
    private Long price;

}
