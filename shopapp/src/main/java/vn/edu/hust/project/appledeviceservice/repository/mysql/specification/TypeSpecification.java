package vn.edu.hust.project.appledeviceservice.repository.mysql.specification;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetTypeRequest;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.TypeModel;

import java.sql.Array;
import java.util.ArrayList;

public class TypeSpecification implements Specification<TypeModel> {

    private final GetTypeRequest filter;

    public TypeSpecification(GetTypeRequest filter) {
        this.filter = filter;
    }
    @Override
    public Predicate toPredicate(Root<TypeModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        final var predicate = new ArrayList<Predicate>();

        if(StringUtils.isNotEmpty(filter.getName())){
            predicate.add(cb.like(root.get("name"), "%s".concat(filter.getName()).concat("%")));
        }
        return cb.and(predicate.toArray(new Predicate[0]));
    }
}
