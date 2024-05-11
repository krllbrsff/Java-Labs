package org.itmo.DTO;

import org.itmo.entities.Owner;

import java.util.Date;

public record OwnerDTO (Long id, String name, Date birthDate) {
    public OwnerDTO(Owner owner) {
        this(
                owner.getId(),
                owner.getName(),
                owner.getBirthDate()
        );
    }

    public Owner toEntity() {
        return Owner.builder()
                .name(name)
                .birthDate(birthDate)
                .build();
    }
}