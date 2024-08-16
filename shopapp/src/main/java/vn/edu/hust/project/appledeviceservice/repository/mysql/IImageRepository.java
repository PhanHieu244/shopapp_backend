package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ImageModel;

import java.util.List;

@Repository
public interface IImageRepository extends IBaseRepository<ImageModel> {
    List<ImageModel> findByEntityIdAndType(Long entityId, String type);
}
