package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ColorModel;

import java.util.List;

@Repository
public interface IColorRepository extends IBaseRepository<ColorModel> {
    List<ColorModel> findByIdIn(List<Long> ids);
}
