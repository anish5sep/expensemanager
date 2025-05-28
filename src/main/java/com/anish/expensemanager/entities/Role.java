package com.anish.expensemanager.entities;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // e.g., ROLE_USER, ROLE_ADMIN
}
