package ru.x3m.rem.dto;


import javax.validation.constraints.*;

public class UserDTO {

    private Long user_id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotNull
    private Long role_id;

    @NotEmpty
    private String matchingPassword;

    //----------------------------
    private String role_name;
    //----------------------------


    public UserDTO(Long user_id, String username, String password, Long role_id, String matchingPassword,
                   String role_name) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.role_id = role_id;
        this.matchingPassword = matchingPassword;
        this.role_name = role_name;
    }

    public UserDTO() {

    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + user_id +
                ", username='" + username + '\'' +
                ", username='" + role_id + '\'' +
                ", password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                '}';
    }


}
