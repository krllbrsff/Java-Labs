package org.itmo.controller;

import org.itmo.DTO.CatDTO;
import org.itmo.common.Color;
import org.itmo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {
    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/{id}")
    public CatDTO getCat(@PathVariable Long id) {
        return catService.getCat(id);
    }

    @GetMapping
    public List<CatDTO> getAllCats() {
        return catService.getAllCats();
    }

    @PostMapping
    public void addCat(@RequestBody CatDTO cat) {
        catService.addCat(cat);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
    }

    @PostMapping("/{catId}/friends/{friendId}")
    public void addFriend(@PathVariable Long catId, @PathVariable Long friendId) {
        catService.addFriend(catId, friendId);
    }

    @DeleteMapping("/{catId}/friends/{friendId}")
    public void removeFriend(@PathVariable Long catId, @PathVariable Long friendId) {
        catService.removeFriend(catId, friendId);
    }

    @GetMapping("/filter")
    public List<CatDTO> getCatsByFilters(@RequestParam(required = false) String name,
                                         @RequestParam(required = false) String breed,
                                         @RequestParam(required = false) Color color,
                                         @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthDate,
                                         @RequestParam(required = false) Long ownerId) {
        return catService.getCatsByFilters(name, breed, color, birthDate, ownerId);
    }
}