package org.example.dao;

import org.example.models.Sneakers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SneakersDAOImpl implements SneakersDAO{
    //private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    //private static Map<Integer, Sneakers> allSneakers = new HashMap<>();

    /*static {
        Sneakers firstPair = new Sneakers();
        firstPair.setId(AUTO_ID.getAndIncrement());
        firstPair.setBrand("Nike");
        firstPair.setSport("Basketball");
        firstPair.setModel("Mamba Rage");
        firstPair.setAmount(2);
        allSneakers.put(firstPair.getId(), firstPair);
    }*/

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Sneakers> allSneakers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Sneakers").list();
    }

    @Override
    public void add(Sneakers sneakers) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(sneakers);
    }

    @Override
    public void delete(Sneakers sneakers) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(sneakers);
    }

    @Override
    public void edit(Sneakers sneakers) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sneakers);
    }

    @Override
    public Sneakers getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Sneakers.class, id);
    }


    /*@Override
    public List<Sneakers> allSneakers() {
        return new ArrayList<>(allSneakers.values());
    }

    @Override
    public void add(Sneakers sneakers) {
        sneakers.setId(AUTO_ID.getAndIncrement());
        allSneakers.put(sneakers.getId(), sneakers);
    }

    @Override
    public void delete(Sneakers sneakers) {
        allSneakers.remove(sneakers.getId());
    }

    @Override
    public void edit(Sneakers sneakers) {
        allSneakers.put(sneakers.getId(), sneakers);
    }

    @Override
    public Sneakers getById(int id) {
        return allSneakers.get(id);
    }*/
}
