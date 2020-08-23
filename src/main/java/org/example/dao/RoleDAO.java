package org.example.dao;

import org.example.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO {

    Role getOne(Long id);
}
