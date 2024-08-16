package vn.edu.hust.project.appledeviceservice.repository.mysql.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetStorageRequest;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.StorageModel;

import java.util.ArrayList;

@AllArgsConstructor
public class StorageSpecification implements Specification<StorageModel> {
    private GetStorageRequest filter;

    @Override
    public Predicate toPredicate(Root<StorageModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        final var predicate = new ArrayList<Predicate>();

        if (!ObjectUtils.isEmpty(filter.getVolume())) {
            predicate.add(cb.equal(root.get("volume"), filter.getVolume()));
        }
        return cb.and(predicate.toArray(new Predicate[0]));
    }
}
