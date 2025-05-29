package com.anish.expensemanager.repository;

import java.util.List;
import com.anish.expensemanager.entities.Expense;
import com.anish.expensemanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);
}
