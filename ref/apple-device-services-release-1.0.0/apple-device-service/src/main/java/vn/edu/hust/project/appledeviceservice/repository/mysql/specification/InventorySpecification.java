package vn.edu.hust.project.appledeviceservice.repository.mysql.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetInventoryRequest;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.InventoryModel;

@RequiredArgsConstructor
public class InventorySpecification implements Specification<InventoryModel> {

    private final GetInventoryRequest filter;

    @Override
    public Predicate toPredicate(Root<InventoryModel> root, CriteriaQuery<?> query,
        CriteriaBuilder cb) {
        final var predicates = new ArrayList<Predicate>();
        if (filter.getProductDetailId() != null) {
            predicates.add(cb.equal(root.get("productDetailId"), filter.getProductDetailId()));
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
