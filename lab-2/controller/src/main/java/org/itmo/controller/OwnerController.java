package org.itmo.controller;

import lombok.AllArgsConstructor;
import org.itmo.DTO.CatDTO;
import org.itmo.DTO.OwnerDTO;
import org.itmo.service.OwnerService;

import java.util.List;

@AllArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerDTO getOwner(Long id) {
        return ownerService.getOwner(id);
    }

    public List<OwnerDTO> getAllOwners() {
        return ownerService.getAllOwners();
    }

    public void addOwner(OwnerDTO owner) {
        ownerService.addOwner(owner);
    }

    public void deleteOwner(Long id) {
        ownerService.deleteOwner(id);
    }

    public void addCat(Long ownerId, CatDTO cat) {
        ownerService.addCat(ownerId, cat);
    }

    public void deleteCat(Long ownerId, CatDTO cat) {
        ownerService.deleteCat(ownerId, cat);
    }
}
