package com.anish.expensemanager.controller;

import com.anish.expensemanager.dto.ExpenseDTO;
import com.anish.expensemanager.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> getAll(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(expenseService.getAllExpenses(userDetails.getUsername()));
    }

    @PostMapping
    public ResponseEntity<ExpenseDTO> addExpense(@AuthenticationPrincipal UserDetails userDetails,
                                                 @RequestBody ExpenseDTO dto) {
        return ResponseEntity.ok(expenseService.addExpense(userDetails.getUsername(), dto));
    }
}
