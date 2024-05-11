package org.itmo.controller;

import org.itmo.DTO.CatDTO;
import org.itmo.service.CatService;

import java.util.List;

public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    public CatDTO getCat(Long id) {
        return catService.getCat(id);
    }

    public List<CatDTO> getAllCats() {
        return catService.getAllCats();
    }

    public void addCat(CatDTO cat) {
        catService.addCat(cat);
    }

    public void deleteCat(Long id) {
        catService.deleteCat(id);
    }

    public void addFriend(Long catId, Long friendId) {
        catService.addFriend(catId, friendId);
    }
}