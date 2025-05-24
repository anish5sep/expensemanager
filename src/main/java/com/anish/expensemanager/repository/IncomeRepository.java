package com.anish.expensemanager.repository;

import com.anish.expensemanager.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
