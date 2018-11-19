package shop.dtos.security;

import shop.dtos.DTO;

import javax.validation.constraints.NotEmpty;

public class UsernamePasswordDTO implements DTO {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
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
    public UsernamePasswordDTO() {
    }
    public UsernamePasswordDTO(@NotEmpty String username, @NotEmpty String password) {
        this.username = username;
        this.password = password;
    }}
