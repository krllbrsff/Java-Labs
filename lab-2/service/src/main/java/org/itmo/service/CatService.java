package org.itmo.service;

import lombok.AllArgsConstructor;
import org.itmo.DTO.CatDTO;
import org.itmo.dao.ICatDao;
import org.itmo.specifications.CatSpecification;
import org.itmo.entities.Cat;
import org.itmo.common.Color;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatService {
    private final ICatDao catDao;

    public CatDTO getCat(Long id) {
        return catDao.findById(id).map(CatDTO::new).orElse(null);
    }

    public List<CatDTO> getAllCats() {
        return catDao.findAll().stream().map(CatDTO::new).collect(Collectors.toList());
    }

    public void addCat(CatDTO catDto) {
        catDao.save(catDto.toEntity());
    }

    public void deleteCat(Long id) {
        catDao.findById(id).ifPresent(catDao::delete);
    }

    public List<CatDTO> getCatsByOwnerId(Long ownerId) {
        return catDao.findByOwnerId(ownerId).stream().map(CatDTO::new).collect(Collectors.toList());
    }

    public void addFriend(Long catId, Long friendId) {
        Cat cat = catDao.findById(catId).orElseThrow(() -> new RuntimeException("Cat not found"));
        Cat friend = catDao.findById(friendId).orElseThrow(() -> new RuntimeException("Friend not found"));

        if (!cat.getFriends().contains(friend)) {
            cat.getFriends().add(friend);
            friend.getFriends().add(cat);

            catDao.save(cat);
            catDao.save(friend);
        }
    }

    public void removeFriend(Long catId, Long friendId) {
        Cat cat = catDao.findById(catId).orElseThrow(() -> new RuntimeException("Cat not found"));
        Cat friend = catDao.findById(friendId).orElseThrow(() -> new RuntimeException("Friend not found"));

        if (cat.getFriends().contains(friend)) {
            cat.getFriends().remove(friend);
            friend.getFriends().remove(cat);

            catDao.save(cat);
            catDao.save(friend);
        }
    }

    public List<CatDTO> getCatsByFilters(String name, String breed, Color color, Date birthDate, Long ownerId) {
        Specification<Cat> spec = Specification.where(CatSpecification.hasName(name))
                .and(CatSpecification.hasBreed(breed))
                .and(CatSpecification.hasColor(color))
                .and(CatSpecification.hasBirthDate(birthDate))
                .and(CatSpecification.hasOwnerId(ownerId));
        return catDao.findAll(spec).stream().map(CatDTO::new).collect(Collectors.toList());
    }
}