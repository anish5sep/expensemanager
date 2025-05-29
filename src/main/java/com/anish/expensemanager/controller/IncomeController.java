package com.anish.expensemanager.controller;

import com.anish.expensemanager.dto.IncomeDTO;
import com.anish.expensemanager.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public ResponseEntity<List<IncomeDTO>> getAll(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(incomeService.getAllIncome(userDetails.getUsername()));
    }

    @PostMapping
    public ResponseEntity<IncomeDTO> addIncome(@AuthenticationPrincipal UserDetails userDetails,
                                               @RequestBody IncomeDTO dto) {
        return ResponseEntity.ok(incomeService.addIncome(userDetails.getUsername(), dto));
    }
}

