package com.anish.expensemanager.serviceimpl;

import com.anish.expensemanager.dto.UserDto;
import com.anish.expensemanager.entities.Role;
import com.anish.expensemanager.entities.User;
import com.anish.expensemanager.exceptions.ResourceNotFoundException;
import com.anish.expensemanager.mapper.UserMapper;
import com.anish.expensemanager.repository.RoleRepository;
import com.anish.expensemanager.repository.UserRepository;
import com.anish.expensemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        Role role = roleRepository.findById(userDto.getRole().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));

        User user = UserMapper.toEntity(userDto);
        user.setRole(role);

        User savedUser = userRepository.save(user);
        return UserMapper.toDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return UserMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        Role role = roleRepository.findById(userDto.getRole().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        user.setRole(role);

        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }
}
