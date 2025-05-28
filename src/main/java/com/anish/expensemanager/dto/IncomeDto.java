package com.anish.expensemanager.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class IncomeDto {
    private Long id;
    private String source;
    private Double amount;
    private LocalDate date;
}
