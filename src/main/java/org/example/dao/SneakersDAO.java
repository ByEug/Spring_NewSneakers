package org.example.dao;

import org.example.models.Sneakers;

import java.util.List;

public interface SneakersDAO {
    List<Sneakers> allSneakers();
    void add(Sneakers sneakers);
    void delete(Sneakers sneakers);
    void edit(Sneakers sneakers);
    Sneakers getById(int id);
}
