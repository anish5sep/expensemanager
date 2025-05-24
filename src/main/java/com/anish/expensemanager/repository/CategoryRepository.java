package com.anish.expensemanager.repository;

import com.anish.expensemanager.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
