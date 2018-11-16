package shop.dtos.security;

import shop.dtos.DTO;

public class UsernamePasswordDTO implements DTO {
    private String username;
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
}
