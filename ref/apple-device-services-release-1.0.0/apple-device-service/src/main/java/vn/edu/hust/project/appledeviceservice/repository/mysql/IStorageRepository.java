package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.StorageModel;

import java.util.List;

@Repository
public interface IStorageRepository extends IBaseRepository<StorageModel> {
    List<StorageModel> findByIdIn(List<Long> ids);
}
