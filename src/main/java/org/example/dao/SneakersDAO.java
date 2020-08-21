package org.example.dao;

import org.example.models.Sneakers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SneakersDAO {
    List<Sneakers> allSneakers();
    List<Sneakers> searchByBrand(String brand);
    void add(Sneakers sneakers);
    void delete(Sneakers sneakers);
    void edit(Sneakers sneakers);
    Sneakers getById(int id);
}
