package com.anish.expensemanager.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseDto {

    private Long id;

    private String title;

    private BigDecimal amount;

    private LocalDate date;

    private CategoryDto category;

    private UserDto user;

}
