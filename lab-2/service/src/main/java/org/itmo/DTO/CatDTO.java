package org.itmo.DTO;

import lombok.Builder;
import org.itmo.entities.Cat;
import org.itmo.entities.Color;
import org.itmo.entities.Owner;

import java.util.Date;
import java.util.List;

@Builder
public record CatDTO(Long id, String name, String breed, Color color, Date birthDate, Owner owner, List<Cat> friends) {
    public CatDTO(Cat cat) {
        this(
                cat.getId(),
                cat.getName(),
                cat.getBreed(),
                cat.getColor(),
                cat.getBirthDate(),
                cat.getOwner(),
                cat.getFriends()
        );
    }

    public Cat toEntity() {
        return Cat.builder()
                .name(name)
                .breed(breed)
                .color(color)
                .birthDate(birthDate)
                .owner(owner)
                .friends(friends)
                .build();
    }
}
