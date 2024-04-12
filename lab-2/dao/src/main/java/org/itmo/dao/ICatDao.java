package org.itmo.dao;

import org.itmo.entities.Cat;

import java.util.List;

public interface ICatDao {
    Cat findById(Long id);
    List<Cat> findAll();
    void save(Cat cat);
    void delete(Cat cat);
    void update(Cat cat);
}
