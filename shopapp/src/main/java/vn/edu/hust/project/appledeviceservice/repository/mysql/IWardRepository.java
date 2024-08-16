package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IBaseRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.WardModel;

import java.util.Optional;

@Repository
public interface IWardRepository extends IBaseRepository<WardModel> {
    Optional<WardModel> findByCode(String code);
}
