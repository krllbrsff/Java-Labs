package org.itmo.service;

import lombok.AllArgsConstructor;
import org.itmo.DTO.CatDTO;
import org.itmo.DTO.OwnerDTO;
import org.itmo.dao.IOwnerDao;
import org.itmo.entities.Owner;
import org.itmo.specifications.OwnerSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OwnerService {
    private final IOwnerDao ownerDao;
    private final CatService catService;

    public OwnerDTO getOwner(Long id) {
        return ownerDao.findById(id).map(OwnerDTO::new).orElse(null);
    }

    public List<OwnerDTO> getAllOwners() {
        return ownerDao.findAll().stream().map(OwnerDTO::new).collect(Collectors.toList());
    }

    public void addOwner(OwnerDTO owner) {
        ownerDao.save(owner.toEntity());
    }

    public void deleteOwner(Long id) {
        ownerDao.findById(id).ifPresent(ownerDao::delete);
    }

    public List<CatDTO> getCatsByOwnerId(Long ownerId) {
        return catService.getCatsByOwnerId(ownerId);
    }

    public List<OwnerDTO> getOwnersByFilters(String name, Date birthDate) {
        Specification<Owner> spec = Specification.where(OwnerSpecification.hasName(name))
                .and(OwnerSpecification.hasBirthDate(birthDate));
        return ownerDao.findAll(spec).stream().map(OwnerDTO::new).collect(Collectors.toList());
    }
}