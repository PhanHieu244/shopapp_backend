package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IBaseRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.DistrictModel;

import java.util.Optional;

@Repository
public interface IDistrictRepository extends IBaseRepository<DistrictModel> {
    Optional<DistrictModel> findByCode(String code);
}
