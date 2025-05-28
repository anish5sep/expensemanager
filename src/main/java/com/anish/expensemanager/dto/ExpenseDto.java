package com.anish.expensemanager.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ExpenseDto {
    private Long id;
    private String title;
    private Double amount;
    private String category;
    private LocalDate date;
}
