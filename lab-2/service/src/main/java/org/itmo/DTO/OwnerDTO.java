package org.itmo.DTO;

import org.itmo.entities.Cat;
import org.itmo.entities.Owner;

import java.util.Date;
import java.util.List;

public record OwnerDTO (Long id, String name, Date birthDate, List<Cat> cats) {
    public OwnerDTO(Owner owner) {
        this(
                owner.getId(),
                owner.getName(),
                owner.getBirthDate(),
                owner.getCats()
        );
    }

    public Owner toEntity() {
        return Owner.builder()
                .name(name)
                .birthDate(birthDate)
                .cats(cats)
                .build();
    }
}
