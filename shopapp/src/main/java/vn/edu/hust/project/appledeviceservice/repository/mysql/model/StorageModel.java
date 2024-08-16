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
@Entity(name="StorageModel")
@Table(name="storages")
public class StorageModel extends BaseModel {
    @Column(name = "volumne")
    private Long volume;

    @Column(name = "unit")
    private String unit;
}
