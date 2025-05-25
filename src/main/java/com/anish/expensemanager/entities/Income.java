package com.anish.expensemanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Income {

    @Id
    private Long id;
    private Double amount;
    private String source;
    private LocalDate date;
    private User user;
}
