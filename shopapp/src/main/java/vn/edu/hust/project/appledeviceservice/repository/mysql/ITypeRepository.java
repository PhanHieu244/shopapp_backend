package vn.edu.hust.project.appledeviceservice.repository.mysql;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.TypeModel;
import vn.edu.hust.project.appledeviceservice.repository.mysql.specification.TypeSpecification;

@Repository
public interface ITypeRepository extends IBaseRepository<TypeModel> {
}
