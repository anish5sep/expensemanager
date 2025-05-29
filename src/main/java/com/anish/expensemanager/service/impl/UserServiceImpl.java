package com.anish.expensemanager.service.impl;

import com.anish.expensemanager.dto.UserDTO;
import com.anish.expensemanager.entities.User;
import com.anish.expensemanager.exceptions.ResourceNotFoundException;
import com.anish.expensemanager.repository.UserRepository;
import com.anish.expensemanager.service.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        return modelMapper.map(user, UserDTO.class);
    }
}
