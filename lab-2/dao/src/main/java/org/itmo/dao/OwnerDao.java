package org.itmo.dao;

import org.hibernate.Session;
import org.itmo.HibernateUtil;
import org.itmo.entities.Owner;

import java.util.List;

public class OwnerDao implements IOwnerDao {

    @Override
    public Owner findById(Long id) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            return session.get(Owner.class, id);
        }
    }

    @Override
    public List<Owner> findAll() {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            return session.createQuery("from Owner", Owner.class).list();
        }
    }

    @Override
    public void save(Owner owner) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            session.beginTransaction();
            session.save(owner);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Owner owner) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            session.beginTransaction();
            session.delete(owner);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Owner owner) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            session.beginTransaction();
            session.update(owner);
            session.getTransaction().commit();
        }
    }
}