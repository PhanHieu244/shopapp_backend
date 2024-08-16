package vn.edu.hust.project.appledeviceservice.repository.mysql.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetBlogRequest;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.BlogModel;

import java.util.ArrayList;

@RequiredArgsConstructor
public class BlogSpecification implements Specification<BlogModel> {
    private final GetBlogRequest filter;
    @Override
    public Predicate toPredicate(Root<BlogModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        var predicates = new ArrayList<Predicate>();
        if (filter.getStatus() != null) {
            predicates.add(cb.equal(root.get("status"), filter.getStatus()));
        }
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
