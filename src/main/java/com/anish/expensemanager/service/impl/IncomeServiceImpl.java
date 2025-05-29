package com.anish.expensemanager.service.impl;

import com.anish.expensemanager.dto.IncomeDTO;
import com.anish.expensemanager.entities.Income;
import com.anish.expensemanager.entities.User;
import com.anish.expensemanager.exceptions.ResourceNotFoundException;
import com.anish.expensemanager.repository.IncomeRepository;
import com.anish.expensemanager.repository.UserRepository;
import com.anish.expensemanager.service.interfaces.IncomeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepository incomeRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<IncomeDTO> getAllIncomes(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        List<Income> incomes = incomeRepo.findByUser(user);

        return incomes.stream()
                .map(income -> modelMapper.map(income, IncomeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public IncomeDTO addIncome(String username, IncomeDTO dto) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        Income income = modelMapper.map(dto, Income.class);
        income.setUser(user);

        Income saved = incomeRepo.save(income);
        return modelMapper.map(saved, IncomeDTO.class);
    }
}
