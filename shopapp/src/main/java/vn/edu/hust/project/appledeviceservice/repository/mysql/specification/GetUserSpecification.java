package vn.edu.hust.project.appledeviceservice.repository.mysql.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetUserRequest;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.UserModel;

import java.util.ArrayList;

@RequiredArgsConstructor
public class GetUserSpecification implements Specification<UserModel> {
    private final GetUserRequest filter;
    @Override
    public Predicate toPredicate(Root<UserModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        var predicates = new ArrayList<Predicate>();
        if (filter.getRoleId() != null) {
            predicates.add(cb.equal(root.get("roleId"), filter.getRoleId()));
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
