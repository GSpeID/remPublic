package ru.x3m.rem.dto;

import ru.x3m.rem.entity.Role;

import javax.validation.constraints.NotEmpty;

public class RoleDTO {

    private int roleId;

    @NotEmpty
    private String roleName;

    public RoleDTO() {
    }

    public RoleDTO(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public RoleDTO(Role role) {
        this.roleId = role.getRoleId();
        this.roleName = role.getRoleName();
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
