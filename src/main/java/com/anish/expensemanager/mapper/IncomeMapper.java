package com.anish.expensemanager.mapper;

import com.anish.expensemanager.dto.IncomeDTO;
import com.anish.expensemanager.entities.Income;

public class IncomeMapper {

    public static IncomeDTO toDto(Income income) {
        IncomeDTO dto = new IncomeDTO();
        dto.setId(income.getId());
        dto.setSource(income.getSource());
        dto.setAmount(income.getAmount());
        dto.setDate(income.getDate());
        return dto;
    }

    public static Income toEntity(IncomeDTO dto) {
        Income income = new Income();
        income.setId(dto.getId());
        income.setSource(dto.getSource());
        income.setAmount(dto.getAmount());
        income.setDate(dto.getDate());
        return income;
    }

    private IncomeMapper(){

    }
}
