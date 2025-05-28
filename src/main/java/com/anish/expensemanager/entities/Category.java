package com.anish.expensemanager.entities;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;
}
