package org.itmo.specifications;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.itmo.entities.Cat;
import org.itmo.common.Color;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class CatSpecification {

    public static Specification<Cat> hasName(String name) {
        return (Root<Cat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (name == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("name"), name);
        };
    }

    public static Specification<Cat> hasBreed(String breed) {
        return (Root<Cat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (breed == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("breed"), breed);
        };
    }

    public static Specification<Cat> hasColor(Color color) {
        return (Root<Cat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (color == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("color"), color);
        };
    }

    public static Specification<Cat> hasBirthDate(Date birthDate) {
        return (Root<Cat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (birthDate == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("birthDate"), birthDate);
        };
    }

    public static Specification<Cat> hasOwnerId(Long ownerId) {
        return (Root<Cat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (ownerId == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("ownerId"), ownerId);
        };
    }
}