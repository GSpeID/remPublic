package ru.x3m.rem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long userId;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotNull
    private Long roleId;

    @NotEmpty
    private String matchingPassword;

    //----------------------------
    private String roleName;
    //----------------------------

}
