package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
public class RoleDTO {

    private int roleId;

    @NotEmpty
    private String roleName;

}
