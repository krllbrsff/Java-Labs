package org.itmo.service;

import lombok.AllArgsConstructor;
import org.itmo.DTO.CatDTO;
import org.itmo.DTO.OwnerDTO;
import org.itmo.dao.IOwnerDao;
import org.itmo.entities.Owner;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OwnerService {
    private final IOwnerDao ownerDao;

    public OwnerDTO getOwner(Long id) {
        return new OwnerDTO(ownerDao.findById(id));
    }

    public List<OwnerDTO> getAllOwners() {
        return ownerDao.findAll().stream().map(OwnerDTO::new).collect(Collectors.toList());
    }

    public void addOwner(OwnerDTO owner) {
        ownerDao.save(owner.toEntity());
    }

    public void deleteOwner(Long id) {
        ownerDao.delete(ownerDao.findById(id));
    }

    public void addCat(Long ownerId, CatDTO cat) {
        Owner owner = ownerDao.findById(ownerId);
        if (owner != null) {
            owner.getCats().add(cat.toEntity());
            cat.toEntity().setOwner(owner);
            ownerDao.update(owner);
        }
    }

    public void deleteCat(Long ownerId, CatDTO cat) {
        Owner owner = ownerDao.findById(ownerId);
        if (owner != null) {
            owner.getCats().remove(cat.toEntity());
            cat.toEntity().setOwner(null);
            ownerDao.update(owner);
        }
    }
}