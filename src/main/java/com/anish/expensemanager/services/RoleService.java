package com.anish.expensemanager.services;

import com.anish.expensemanager.dto.RoleDTO;
import java.util.List;

public interface RoleService {
    RoleDTO createRole(RoleDTO roleDTO);
    RoleDTO getRoleById(Long id);
    List<RoleDTO> getAllRoles();
    void deleteRole(Long id);
}
