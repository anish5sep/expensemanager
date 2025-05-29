package com.anish.expensemanager.services;

import com.anish.expensemanager.dto.IncomeDTO;
import com.anish.expensemanager.entities.Income;
import com.anish.expensemanager.entities.User;
import com.anish.expensemanager.exceptions.ResourceNotFoundException;
import com.anish.expensemanager.repository.IncomeRepository;
import com.anish.expensemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired private ModelMapper modelMapper;

    public List<IncomeDTO> getAllIncome(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return incomeRepository.findByUser(user).stream()
                .map(income -> modelMapper.map(income, IncomeDTO.class))
                .collect(Collectors.toList());
    }

    public IncomeDTO addIncome(String username, IncomeDTO dto) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Income income = modelMapper.map(dto, Income.class);
        income.setUser(user);
        Income saved = incomeRepository.save(income);
        return modelMapper.map(saved, IncomeDTO.class);
    }
}
