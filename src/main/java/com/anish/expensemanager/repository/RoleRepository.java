package com.anish.expensemanager.repository;

import java.util.Optional;
import com.anish.expensemanager.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
