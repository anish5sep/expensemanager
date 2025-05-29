package com.anish.expensemanager.controller;

import com.anish.expensemanager.constants.AppConstants;
import com.anish.expensemanager.dto.ExpenseDTO;
import com.anish.expensemanager.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.EXPENSE_URL) // "/expenses"
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDto) {
        ExpenseDTO createdExpense = expenseService.createExpense(expenseDto);
        return ResponseEntity.ok(createdExpense);
    }

    @GetMapping(AppConstants.GET_EXPENSE_BY_ID) // "/{id}"
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable Long id) {
        ExpenseDTO expense = expenseService.getExpenseById(id);
        return ResponseEntity.ok(expense);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses() {
        List<ExpenseDTO> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @PutMapping(AppConstants.UPDATE_EXPENSE) // "/{id}"
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO expenseDto) {
        ExpenseDTO updatedExpense = expenseService.updateExpense(id, expenseDto);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping(AppConstants.DELETE_EXPENSE) // "/{id}"
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
