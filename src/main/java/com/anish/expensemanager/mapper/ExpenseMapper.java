package com.anish.expensemanager.mapper;

import com.anish.expensemanager.dto.ExpenseDto;
import com.anish.expensemanager.entities.Expense;

public class ExpenseMapper {

    public static ExpenseDto toDto(Expense expense) {
        ExpenseDto dto = new ExpenseDto();
        dto.setId(expense.getId());
        dto.setTitle(expense.getTitle());
        dto.setAmount(expense.getAmount());
        dto.setCategory(expense.getCategory());
        dto.setDate(expense.getDate());
        return dto;
    }

    public static Expense toEntity(ExpenseDto dto) {
        Expense expense = new Expense();
        expense.setId(dto.getId());
        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setCategory(dto.getCategory());
        expense.setDate(dto.getDate());
        return expense;
    }
}
