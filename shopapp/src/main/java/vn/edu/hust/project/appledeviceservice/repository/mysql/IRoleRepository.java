package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.RoleModel;

import java.util.Optional;

@Repository
public interface IRoleRepository extends IBaseRepository<RoleModel> {
    Optional<RoleModel> findByCode(String code);
}
