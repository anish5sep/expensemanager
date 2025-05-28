package com.anish.expensemanager.controller;

import com.anish.expensemanager.constants.AppConstants;
import com.anish.expensemanager.dto.IncomeDto;
import com.anish.expensemanager.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.INCOME_URL)  // "/incomes"
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    public ResponseEntity<IncomeDto> createIncome(@RequestBody IncomeDto incomeDto) {
        IncomeDto createdIncome = incomeService.createIncome(incomeDto);
        return ResponseEntity.ok(createdIncome);
    }

    @GetMapping(AppConstants.GET_INCOME_BY_ID) // "/{id}"
    public ResponseEntity<IncomeDto> getIncomeById(@PathVariable Long id) {
        IncomeDto income = incomeService.getIncomeById(id);
        return ResponseEntity.ok(income);
    }

    @GetMapping
    public ResponseEntity<List<IncomeDto>> getAllIncomes() {
        List<IncomeDto> incomes = incomeService.getAllIncomes();
        return ResponseEntity.ok(incomes);
    }

    @PutMapping(AppConstants.UPDATE_INCOME) // "/{id}"
    public ResponseEntity<IncomeDto> updateIncome(@PathVariable Long id, @RequestBody IncomeDto incomeDto) {
        IncomeDto updatedIncome = incomeService.updateIncome(id, incomeDto);
        return ResponseEntity.ok(updatedIncome);
    }

    @DeleteMapping(AppConstants.DELETE_INCOME) // "/{id}"
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }
}
