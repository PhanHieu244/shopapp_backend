package vn.edu.hust.project.appledeviceservice.repository.mysql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Product Model")
@Table(name = "products")
public class ProductModel extends BaseModel{

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "banner_img")
    private String bannerImg;

    @Column(name = "status")
    private String status;

    @Column(name = "warranty_duration")
    private Long warrantyDuration;

    @Column(name = "type_id")
    private Long typeId;

}
