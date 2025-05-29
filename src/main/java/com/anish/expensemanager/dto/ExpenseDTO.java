package com.anish.expensemanager.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ExpenseDTO {
    private Long id;
    private String title;
    private String category;
    private double amount;
    private LocalDate date;

}
