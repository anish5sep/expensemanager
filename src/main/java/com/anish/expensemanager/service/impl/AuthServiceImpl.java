package com.anish.expensemanager.service.impl;

import com.anish.expensemanager.dto.AuthRequest;
import com.anish.expensemanager.dto.AuthResponse;
import com.anish.expensemanager.entities.Role;
import com.anish.expensemanager.entities.User;
import com.anish.expensemanager.repository.RoleRepository;
import com.anish.expensemanager.repository.UserRepository;
import com.anish.expensemanager.security.JwtTokenProvider;

import com.anish.expensemanager.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public abstract class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse login(AuthRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()));

        String token = jwtTokenProvider.generateToken(request.getUsername());
        return new AuthResponse(token);
    }

    @Override
    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepo.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRoles(Collections.singleton(userRole));
        userRepo.save(user);
        return "User registered successfully!";
    }
}
