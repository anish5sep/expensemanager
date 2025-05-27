package com.anish.expensemanager.constants;

public class AppConstants {

    // BASE
    public static final String BASE_URL = "/api";

    // AUTH
    public static final String AUTH_URL = "/auth";
    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";

    // USERS
    public static final String USER_URL = "/users";
    public static final String CURRENT_USER = "/me";
    public static final String UPDATE_USER = "/{id}";
    public static final String DELETE_USER = "/{id}";

    // EXPENSE
    public static final String EXPENSE_URL = "/expenses";
    public static final String GET_EXPENSE_BY_ID = "/{id}";
    public static final String UPDATE_EXPENSE = "/{id}";
    public static final String DELETE_EXPENSE = "/{id}";

    // INCOME
    public static final String INCOME_URL = "/incomes";
    public static final String GET_INCOME_BY_ID = "/{id}";
    public static final String UPDATE_INCOME = "/{id}";
    public static final String DELETE_INCOME = "/{id}";

    // ANALYTICS
    public static final String ANALYTICS_URL = "/analytics";
    public static final String MONTHLY_ANALYTICS = "/monthly";
    public static final String CATEGORY_ANALYTICS = "/category";

    // OTHER CONSTANTS
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    public static final int DEFAULT_PAGE_NUMBER = 0;
    public static final int DEFAULT_PAGE_SIZE = 10;

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    // MESSAGES
    public static final String USER_ALREADY_EXISTS = "User with this email already exists.";
    public static final String EXPENSE_NOT_FOUND = "Expense not found with id: ";
    public static final String INCOME_NOT_FOUND = "Income not found with id: ";

    private AppConstants(){
    }
}
