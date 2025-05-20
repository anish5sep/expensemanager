package com.anish.expensemanager.repository;

import com.anish.expensemanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
