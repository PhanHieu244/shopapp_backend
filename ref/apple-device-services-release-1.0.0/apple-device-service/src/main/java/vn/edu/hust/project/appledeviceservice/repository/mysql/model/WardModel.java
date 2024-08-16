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
@Entity(name = "Ward Model")
@Table(name = "wards")
public class WardModel extends BaseModel{
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "district_code")
    private String districtCode;

    @Column(name = "level")
    private String level;
}
