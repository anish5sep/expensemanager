package com.anish.expensemanager.controller;

import com.anish.expensemanager.dto.AuthRequest;
import com.anish.expensemanager.dto.AuthResponse;
import com.anish.expensemanager.entities.User;
import com.anish.expensemanager.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(user));
    }
}
