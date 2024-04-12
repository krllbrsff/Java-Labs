package org.itmo.dao;

import org.itmo.entities.Owner;

import java.util.List;

public interface IOwnerDao {
    Owner findById(Long id);
    List<Owner> findAll();
    void save(Owner owner);
    void delete(Owner owner);
    void update(Owner owner);
}
