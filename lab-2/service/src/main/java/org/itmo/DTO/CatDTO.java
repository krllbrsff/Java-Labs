package org.itmo.DTO;

import lombok.Builder;
import org.itmo.entities.Cat;
import org.itmo.common.Color;

import java.util.Date;

@Builder
public record CatDTO(Long id, String name, String breed, Color color, Date birthDate, Long ownerId) {
    public CatDTO(Cat cat) {
        this(
                cat.getId(),
                cat.getName(),
                cat.getBreed(),
                cat.getColor(),
                cat.getBirthDate(),
                cat.getOwnerId()
        );
    }

    public Cat toEntity() {
        return Cat.builder()
                .name(name)
                .breed(breed)
                .color(color)
                .birthDate(birthDate)
                .ownerId(ownerId)
                .build();
    }
}