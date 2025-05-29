package com.anish.expensemanager.services;

import com.anish.expensemanager.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {
    ExpenseDTO createExpense(ExpenseDTO expenseDto);
    ExpenseDTO getExpenseById(Long id);
    List<ExpenseDTO> getAllExpenses();
    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDto);
    void deleteExpense(Long id);
}
