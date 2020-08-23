package org.example.dao;

import org.example.models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getOne(Long id) {

        Session session = sessionFactory.getCurrentSession();

        List<Role> all_roles = session.createQuery("from Role").list();

        for (Role role : all_roles) {
            if (role.getId().equals(id)) {
                System.out.println("getOne_works_correct");
                return role;
            }
        }
        return null;
    }
}
