package com.anish.expensemanager.mapper;

import com.anish.expensemanager.dto.RoleDTO;
import com.anish.expensemanager.entities.Role;

public class RoleMapper {

    private RoleMapper() {}

    public static RoleDTO toDTO(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        return dto;
    }

    public static Role toEntity(RoleDTO dto) {
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(dto.getName());
        return role;
    }
}
