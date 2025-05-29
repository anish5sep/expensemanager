package com.anish.expensemanager.services;

import com.anish.expensemanager.dto.ExpenseDTO;
import com.anish.expensemanager.entities.Expense;
import com.anish.expensemanager.entities.User;
import com.anish.expensemanager.exceptions.ResourceNotFoundException;
import com.anish.expensemanager.repository.ExpenseRepository;
import com.anish.expensemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<ExpenseDTO> getAllExpenses(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return expenseRepository.findByUser(user).stream()
                .map(expense -> modelMapper.map(expense, ExpenseDTO.class))
                .collect(Collectors.toList());
    }

    public ExpenseDTO addExpense(String username, ExpenseDTO dto) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Expense expense = modelMapper.map(dto, Expense.class);
        expense.setUser(user);
        Expense saved = expenseRepository.save(expense);
        return modelMapper.map(saved, ExpenseDTO.class);
    }
}
