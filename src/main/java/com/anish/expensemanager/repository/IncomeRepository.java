package com.anish.expensemanager.repository;

import java.util.List;

import com.anish.expensemanager.entities.Income;
import com.anish.expensemanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByUser(User user);
}
