package com.anish.expensemanager.service.interfaces;

import com.anish.expensemanager.dto.AuthRequest;
import com.anish.expensemanager.dto.AuthResponse;
import com.anish.expensemanager.entities.User;


public interface AuthService {
    AuthResponse login(AuthRequest request);
    String register(User user);
}
