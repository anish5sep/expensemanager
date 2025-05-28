package com.anish.expensemanager.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ExpenseDto {

    private Long id;

    private String title;

    private Double amount;

    private CategoryDto category;

    private LocalDate date;

    private Long userId;
}
