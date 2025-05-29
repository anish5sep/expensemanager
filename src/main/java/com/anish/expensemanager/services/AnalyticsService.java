package com.anish.expensemanager.services;

import java.util.Map;

public interface AnalyticsService {
    Map<String, Double> getMonthlyExpenseAnalytics(Long userId, int year);
    Map<String, Double> getCategoryWiseExpenseAnalytics(Long userId);
}
