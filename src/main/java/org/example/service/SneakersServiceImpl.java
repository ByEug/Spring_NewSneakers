package org.example.service;

import org.example.dao.SneakersDAO;
import org.example.dao.SneakersDAOImpl;
import org.example.models.Sneakers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SneakersServiceImpl implements SneakersService{
    private SneakersDAO sneakersDAO;

    @Autowired
    public void setSneakersDAO(SneakersDAO sneakersDAO) {
        this.sneakersDAO = sneakersDAO;
    }

    @Override
    @Transactional
    public List<Sneakers> allSneakers() {
        return sneakersDAO.allSneakers();
    }

    @Override
    @Transactional
    public void add(Sneakers sneakers) {
        sneakersDAO.add(sneakers);
    }

    @Override
    @Transactional
    public void delete(Sneakers sneakers) {
        sneakersDAO.delete(sneakers);
    }

    @Override
    @Transactional
    public void edit(Sneakers sneakers) {
        sneakersDAO.edit(sneakers);
    }

    @Override
    @Transactional
    public Sneakers getById(int id) {
        return sneakersDAO.getById(id);
    }
}
