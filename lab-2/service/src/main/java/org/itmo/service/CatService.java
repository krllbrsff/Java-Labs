package org.itmo.service;

import lombok.AllArgsConstructor;
import org.itmo.DTO.CatDTO;
import org.itmo.dao.ICatDao;
import org.itmo.entities.Cat;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CatService {
    private final ICatDao catDao;

    public CatDTO getCat(Long id) {

        return new CatDTO(catDao.findById(id));
    }

    public List<CatDTO> getAllCats() {

        return catDao.findAll().stream().map(CatDTO::new).collect(Collectors.toList());
    }

    public void addCat(CatDTO catDto) {
        catDao.save(catDto.toEntity());
    }

    public void deleteCat(Long id) {
        Cat cat = catDao.findById(id);
        catDao.delete(cat);
    }

    public void addFriend(Long catId, Long friendId) {
        Cat cat = catDao.findById(catId);
        Cat friend = catDao.findById(friendId);
        if (cat != null && friend != null) {
            cat.getFriends().add(friend);
            catDao.update(cat);
        }
    }
}
