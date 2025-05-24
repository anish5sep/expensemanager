package com.anish.expensemanager.repository;

import com.anish.expensemanager.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense , Long> {
}
