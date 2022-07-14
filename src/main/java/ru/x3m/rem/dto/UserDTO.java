package ru.x3m.rem.dto;

import ru.x3m.rem.entity.User;

import javax.validation.constraints.*;

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


    public UserDTO() {
    }

    public UserDTO(Long userId, String username, String password,
                   Long roleId, String matchingPassword, String roleName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.matchingPassword = matchingPassword;
        this.roleName = roleName;
    }

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roleId = user.getRoleId();
        this.roleName = user.getRole().getRoleName();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + userId +
                ", username='" + username + '\'' +
                ", username='" + roleId + '\'' +
                ", password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                '}';
    }


}
