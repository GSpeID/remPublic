package ru.x3m.rem.dto;

import javax.validation.constraints.NotEmpty;

public class RoleDTO {

    private int role_id;

    @NotEmpty
    private String role_name;

    public RoleDTO(int role_id, @NotEmpty String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
