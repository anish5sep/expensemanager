package com.anish.expensemanager.mapper;

import com.anish.expensemanager.dto.RoleDto;
import com.anish.expensemanager.entities.Role;

public class RoleMapper {

    private RoleMapper() {
    }

    public static RoleDto toDto(Role role) {
        RoleDto dto = new RoleDto();
        dto.setId(role.getId());
        dto.setName(role.getName());
        return dto;
    }

    public static Role toEntity(RoleDto dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        return role;
    }
}
