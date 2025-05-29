package com.anish.expensemanager.service.impl;

import com.anish.expensemanager.dto.ExpenseDTO;
import com.anish.expensemanager.entities.Expense;
import com.anish.expensemanager.entities.User;
import com.anish.expensemanager.exceptions.ResourceNotFoundException;
import com.anish.expensemanager.repository.ExpenseRepository;
import com.anish.expensemanager.repository.UserRepository;
import com.anish.expensemanager.service.interfaces.ExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ExpenseDTO> getAllExpenses(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        List<Expense> expenses = expenseRepo.findByUser(user);

        return expenses.stream()
                .map(expense -> modelMapper.map(expense, ExpenseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO addExpense(String username, ExpenseDTO dto) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        Expense expense = modelMapper.map(dto, Expense.class);
        expense.setUser(user);

        Expense saved = expenseRepo.save(expense);
        return modelMapper.map(saved, ExpenseDTO.class);
    }
}
