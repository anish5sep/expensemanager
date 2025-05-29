package com.anish.expensemanager.services.serviceimpl;

import com.anish.expensemanager.dto.IncomeDTO;
import com.anish.expensemanager.entities.Income;
import com.anish.expensemanager.exceptions.ResourceNotFoundException;
import com.anish.expensemanager.repository.IncomeRepository;
import com.anish.expensemanager.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public IncomeDTO createIncome(IncomeDTO incomeDTO) {
        Income income = new Income();
        income.setSource(incomeDTO.getSource());
        income.setDescription(incomeDTO.getDescription());
        income.setAmount(incomeDTO.getAmount());
        income.setDate(incomeDTO.getDate());
        return mapToDTO(incomeRepository.save(income));
    }

    @Override
    public IncomeDTO getIncomeById(Long id) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Income not found with id: " + id));
        return mapToDTO(income);
    }

    @Override
    public List<IncomeDTO> getAllIncomes() {
        return incomeRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Income not found with id: " + id));

        income.setSource(incomeDTO.getSource());
        income.setDescription(incomeDTO.getDescription());
        income.setAmount(incomeDTO.getAmount());
        income.setDate(incomeDTO.getDate());
        return mapToDTO(incomeRepository.save(income));
    }

    @Override
    public void deleteIncome(Long id) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Income not found with id: " + id));
        incomeRepository.delete(income);
    }

    private IncomeDTO mapToDTO(Income income) {
        IncomeDTO dto = new IncomeDTO();
        dto.setId(income.getId());
        dto.setSource(income.getSource());
        dto.setDescription(income.getDescription());
        dto.setAmount(income.getAmount());
        dto.setDate(income.getDate());
        if (income.getUser() != null)
            dto.setUserId(income.getUser().getId());
        return dto;
    }
}