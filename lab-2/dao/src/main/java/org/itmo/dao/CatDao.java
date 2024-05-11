package org.itmo.dao;

import org.hibernate.Session;
import org.itmo.HibernateUtil;
import org.itmo.entities.Cat;

import java.util.List;

public class CatDao implements ICatDao {

    @Override
    public Cat findById(Long id) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            return session.get(Cat.class, id);
        }
    }

    @Override
    public List<Cat> findAll() {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            return session.createQuery("from Cat", Cat.class).list();
        }
    }

    @Override
    public void save(Cat cat) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            session.beginTransaction();
            session.save(cat);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Cat cat) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            session.beginTransaction();
            session.delete(cat);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Cat cat) {
        try (Session session = HibernateUtil.getFactory().openSession()) {
            session.beginTransaction();
            session.update(cat);
            session.getTransaction().commit();
        }
    }
}