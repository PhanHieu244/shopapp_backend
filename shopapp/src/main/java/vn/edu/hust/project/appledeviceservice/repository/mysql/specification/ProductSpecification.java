package vn.edu.hust.project.appledeviceservice.repository.mysql.specification;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductRequest;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductModel;

import java.util.ArrayList;

@RequiredArgsConstructor
public class ProductSpecification implements Specification<ProductModel> {

    private final GetProductRequest filter;

    @Override
    public Predicate toPredicate(Root<ProductModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        final var predicates = new ArrayList<Predicate>();

        if (StringUtils.isNotBlank(filter.getName())) {
            predicates.add(
                    cb.like(root.get("name"), "%".concat(filter.getName()).concat("%"))
            );
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
