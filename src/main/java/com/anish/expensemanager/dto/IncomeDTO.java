package com.anish.expensemanager.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class IncomeDTO {
    private Long id;
    private String source;
    private String description;
    private double amount;
    private LocalDate date;
    private Long userId;
}