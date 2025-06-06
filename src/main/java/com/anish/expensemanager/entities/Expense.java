package com.anish.expensemanager.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String category;

    private double amount;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

