package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProvinceModel;

import java.util.Optional;

@Repository
public interface IProvinceRepository extends IBaseRepository<ProvinceModel> {
    Optional<ProvinceModel> findByCode(String code);
}
