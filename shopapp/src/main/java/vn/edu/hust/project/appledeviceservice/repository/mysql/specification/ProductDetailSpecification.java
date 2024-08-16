package vn.edu.hust.project.appledeviceservice.repository.mysql.specification;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ProductDetailModel;

import java.util.ArrayList;

@RequiredArgsConstructor
public class ProductDetailSpecification implements Specification<ProductDetailModel> {

    private final GetProductDetailRequest filter;

    @Override
    public Predicate toPredicate(Root<ProductDetailModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        final var predicates = new ArrayList<Predicate>();
        if (StringUtils.isNotBlank(filter.getName())) {
            predicates.add(cb.like(root.get("name"),
                    "%".concat(filter.getName()).concat("%")));
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
