package com.anish.expensemanager.service.interfaces;

import com.anish.expensemanager.dto.ExpenseDTO;
import java.util.List;


public interface ExpenseService {
    List<ExpenseDTO> getAllExpenses(String username);
    ExpenseDTO addExpense(String username, ExpenseDTO expenseDTO);
}
