package vn.edu.hust.project.appledeviceservice.repository.mysql.model;

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
@Entity(name="Role Model")
@Table(name="roles")
public class RoleModel extends BaseModel{
    private String name;

    private String code;
}
