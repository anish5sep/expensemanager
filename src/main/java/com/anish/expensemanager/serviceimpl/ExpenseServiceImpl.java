package com.anish.expensemanager.serviceimpl;

import com.anish.expensemanager.dto.ExpenseDto;
import com.anish.expensemanager.entities.Category;
import com.anish.expensemanager.entities.Expense;
import com.anish.expensemanager.entities.User;
import com.anish.expensemanager.exceptions.ResourceNotFoundException;
import com.anish.expensemanager.mapper.ExpenseMapper;
import com.anish.expensemanager.repository.CategoryRepository;
import com.anish.expensemanager.repository.ExpenseRepository;
import com.anish.expensemanager.repository.UserRepository;
import com.anish.expensemanager.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto dto) {
        // Category check
        Category category = categoryRepository.findById(dto.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + dto.getCategory().getId()));

        // User check
        User user = userRepository.findById(dto.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + dto.getUser().getId()));

        Expense expense = ExpenseMapper.toEntity(dto);
        expense.setCategory(category);
        expense.setUser(user);

        Expense savedExpense = expenseRepository.save(expense);
        return ExpenseMapper.toDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));
        return ExpenseMapper.toDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        return expenseRepository.findAll()
                .stream()
                .map(ExpenseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto dto) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + id));

        Category category = categoryRepository.findById(dto.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + dto.getCategory().getId()));

        User user = userRepository.findById(dto.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + dto.getUser().getId()));

        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());
        expense.setCategory(category);
        expense.setUser(user);

        Expense updatedExpense = expenseRepository.save(expense);
        return ExpenseMapper.toDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        if (!expenseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Expense not found with id: " + id);
        }
        expenseRepository.deleteById(id);
    }
}
