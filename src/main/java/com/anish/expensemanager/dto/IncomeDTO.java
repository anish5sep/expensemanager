package com.anish.expensemanager.dto;

import lombok.Data;
import java.time.LocalDate;


@Data
public class IncomeDTO {
    private Long id;
    private String source;
    private double amount;
    private LocalDate date;

}
