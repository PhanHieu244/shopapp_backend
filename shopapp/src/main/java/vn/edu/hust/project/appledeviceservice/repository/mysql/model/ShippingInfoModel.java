package vn.edu.hust.project.appledeviceservice.repository.mysql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Shipping Info Model")
@Table(name = "shipping_infos")
public class ShippingInfoModel extends BaseModel{
    @Column(name = "gender")
    private String gender;

    @Column(name = "received_name")
    private String receivedName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "ward_code")
    private String wardCode;

    @Column(name = "district_code")
    private String districtCode;

    @Column(name = "province_code")
    private String provinceCode;

    @Column(name = "note")
    private String note;

    @Column(name = "user_id")
    private Long userId;
}
