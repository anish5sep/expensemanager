package com.anish.expensemanager.serviceimpl;

import com.anish.expensemanager.entities.Expense;
import com.anish.expensemanager.repository.ExpenseRepository;
import com.anish.expensemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.TextStyle;
import java.time.Month;
import java.util.*;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Map<String, Double> getMonthlyExpenseAnalytics(Long userId, int year) {
        // Validate user
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        List<Expense> expenses = expenseRepository.findAll();

        Map<String, Double> monthlyTotals = new LinkedHashMap<>();
        for (Month month : Month.values()) {
            String monthName = month.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
            monthlyTotals.put(monthName, 0.0);
        }

        for (Expense expense : expenses) {
            if (expense.getUser().getId().equals(userId) && expense.getDate().getYear() == year) {
                String month = expense.getDate().getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
                monthlyTotals.put(month, monthlyTotals.get(month) + expense.getAmount());
            }
        }

        return monthlyTotals;
    }

    @Override
    public Map<String, Double> getCategoryWiseExpenseAnalytics(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        List<Expense> expenses = expenseRepository.findAll();

        Map<String, Double> categoryTotals = new HashMap<>();
        for (Expense expense : expenses) {
            if (expense.getUser().getId().equals(userId)) {
                String categoryName = expense.getCategory().getName();
                categoryTotals.put(categoryName,
                        categoryTotals.getOrDefault(categoryName, 0.0) + expense.getAmount());
            }
        }

        return categoryTotals;
    }
}
