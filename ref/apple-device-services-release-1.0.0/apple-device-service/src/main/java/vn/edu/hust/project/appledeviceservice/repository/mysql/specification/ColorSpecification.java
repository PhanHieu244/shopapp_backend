package vn.edu.hust.project.appledeviceservice.repository.mysql.specification;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetColorRequest;
import vn.edu.hust.project.appledeviceservice.repository.mysql.model.ColorModel;

import java.util.ArrayList;


public class ColorSpecification implements Specification<ColorModel> {
    private GetColorRequest filter;
    public ColorSpecification(GetColorRequest filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<ColorModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        final var predicate = new ArrayList<Predicate>();

        if(StringUtils.isNotEmpty(filter.getName())){
            predicate.add(cb.like(root.get("name"), "%".concat(filter.getName()).concat("%")));
        }

        return cb.and(predicate.toArray(new Predicate[0]));
    }
}
