package com.anish.expensemanager.mapper;

import com.anish.expensemanager.dto.UserDto;
import com.anish.expensemanager.dto.RoleDto;
import com.anish.expensemanager.entities.User;
import com.anish.expensemanager.entities.Role;

public class UserMapper {

    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        RoleDto roleDto = new RoleDto();
        roleDto.setId(user.getRole().getId());
        roleDto.setName(user.getRole().getName());

        dto.setRole(roleDto);
        return dto;
    }

    public static User toEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        Role role = new Role();
        role.setId(dto.getRole().getId());
        role.setName(dto.getRole().getName());

        user.setRole(role);
        return user;
    }

    private UserMapper(){

    }
}
