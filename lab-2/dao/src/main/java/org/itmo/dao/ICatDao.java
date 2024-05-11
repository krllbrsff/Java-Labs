package org.itmo.dao;

import org.itmo.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICatDao extends JpaRepository<Cat, Long>, JpaSpecificationExecutor<Cat> {
    @Query("SELECT c FROM Cat c WHERE c.ownerId = :ownerId")
    List<Cat> findByOwnerId(@Param("ownerId") Long ownerId);
}