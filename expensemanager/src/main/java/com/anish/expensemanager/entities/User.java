package com.anish.expensemanager.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String roles;
    private Timestamp createdAt;
}
