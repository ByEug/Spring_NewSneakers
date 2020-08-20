package org.example.service;

import org.example.models.Sneakers;

import java.util.List;

public interface SneakersService {
    List<Sneakers> allSneakers();
    void add(Sneakers sneakers);
    void delete(Sneakers sneakers);
    void edit(Sneakers sneakers);
    Sneakers getById(int id);
}
