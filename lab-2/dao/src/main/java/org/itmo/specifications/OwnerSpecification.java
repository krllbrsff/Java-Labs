package org.itmo.specifications;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.itmo.entities.Owner;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class OwnerSpecification {

    public static Specification<Owner> hasName(String name) {
        return (Root<Owner> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (name == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("name"), name);
        };
    }

    public static Specification<Owner> hasBirthDate(Date birthDate) {
        return (Root<Owner> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (birthDate == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("birthDate"), birthDate);
        };
    }
}