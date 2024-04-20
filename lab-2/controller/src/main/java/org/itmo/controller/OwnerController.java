package org.itmo.controller;

import lombok.AllArgsConstructor;
import org.itmo.DTO.CatDTO;
import org.itmo.DTO.OwnerDTO;
import org.itmo.service.OwnerService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/owners")
@AllArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @GetMapping("/{id}")
    public OwnerDTO getOwner(@PathVariable Long id) {
        return ownerService.getOwner(id);
    }

    @GetMapping
    public List<OwnerDTO> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @PostMapping
    public void addOwner(@RequestBody OwnerDTO owner) {
        ownerService.addOwner(owner);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
    }

    @GetMapping("/{id}/cats")
    public List<CatDTO> getOwnerCats(@PathVariable Long id) {
        return ownerService.getCatsByOwnerId(id);
    }

    @GetMapping("/filter")
    public List<OwnerDTO> getOwnersByFilters(@RequestParam(required = false) String name,
                                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthDate) {
        return ownerService.getOwnersByFilters(name, birthDate);
    }
}