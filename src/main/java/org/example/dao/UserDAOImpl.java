package org.example.dao;

import org.example.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findByUsername(String username) {

        Session session = sessionFactory.getCurrentSession();
        List<User> all_users = session.createQuery("from User").list();
        for (User user : all_users) {
            if (user.getUsername().equals(username)) {
                System.out.println("findByUsername_works_correct");
                return user;
            }
        }
        return null;
    }

    @Override
    public void save(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        System.out.println("save works correct");
    }
}
