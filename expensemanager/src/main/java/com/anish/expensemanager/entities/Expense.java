package com.anish.expensemanager.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expense {

    private Long id;
    private  Double amount;
    private String description;
    private String category;
    private LocalDate date;
    private User user;
}
