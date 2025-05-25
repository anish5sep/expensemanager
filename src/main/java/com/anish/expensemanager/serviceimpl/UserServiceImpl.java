package com.anish.expensemanager.serviceimpl;

import com.anish.expensemanager.repository.*;

public class UserServiceImpl {

    private final CategoryRepository categoryRepository;
    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public UserServiceImpl(CategoryRepository categoryRepository, ExpenseRepository expenseRepository,
                           IncomeRepository incomeRepository , RoleRepository roleRepository, UserRepository userRepository){
        this.categoryRepository = categoryRepository;
        this.expenseRepository = expenseRepository;
        this.incomeRepository = incomeRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }



}
