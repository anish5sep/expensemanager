package com.anish.expensemanager.mapper;

import com.anish.expensemanager.dto.IncomeDto;
import com.anish.expensemanager.entities.Income;

public class IncomeMapper {

    public static IncomeDto toDto(Income income) {
        IncomeDto dto = new IncomeDto();
        dto.setId(income.getId());
        dto.setSource(income.getSource());
        dto.setAmount(income.getAmount());
        dto.setDate(income.getDate());
        return dto;
    }

    public static Income toEntity(IncomeDto dto) {
        Income income = new Income();
        income.setId(dto.getId());
        income.setSource(dto.getSource());
        income.setAmount(dto.getAmount());
        income.setDate(dto.getDate());
        return income;
    }
}
