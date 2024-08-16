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
public class ProductDetailEntity extends BaseEntity {

    private String name;

    private String bannerImg;

    private Long productId;

    private Long colorId;

    private Long storageId;

    private Long unitPrice;

    private Long price;

    private List<ImageEntity> images;

    private ColorEntity color;

    private StorageEntity storage;

    private InventoryEntity inventory;

    private ProductEntity product;

}
