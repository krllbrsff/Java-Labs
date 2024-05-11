package org.itmo.dao;

import org.itmo.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerDao extends JpaRepository<Owner, Long>, JpaSpecificationExecutor<Owner> {
}