package com.anish.expensemanager.mapper;

import com.anish.expensemanager.dto.CategoryDto;
import com.anish.expensemanager.dto.ExpenseDto;
import com.anish.expensemanager.entities.Category;
import com.anish.expensemanager.entities.Expense;
import com.anish.expensemanager.entities.User;

public class ExpenseMapper {

    public static ExpenseDto toDto(Expense expense) {
        ExpenseDto dto = new ExpenseDto();
        dto.setId(expense.getId());
        dto.setTitle(expense.getTitle());
        dto.setAmount(expense.getAmount());
        dto.setDate(expense.getDate());
        dto.setUserId(expense.getUser().getId());

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(expense.getCategory().getId());
        categoryDto.setName(expense.getCategory().getName());
        categoryDto.setDescription(expense.getCategory().getDescription());

        dto.setCategory(categoryDto);

        return dto;
    }

    public static Expense toEntity(ExpenseDto dto, User user, Category category) {
        Expense expense = new Expense();
        expense.setId(dto.getId());
        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());
        expense.setUser(user);
        expense.setCategory(category);
        return expense;
    }

    private ExpenseMapper(){

    }
}
