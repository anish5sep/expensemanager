package com.anish.expensemanager.service.interfaces;

import com.anish.expensemanager.dto.UserDTO;


public interface UserService {
    UserDTO getUserByUsername(String username);
}

