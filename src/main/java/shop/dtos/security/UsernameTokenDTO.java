package shop.dtos.security;

import shop.dtos.DTO;

import javax.validation.constraints.NotEmpty;

public class UsernameTokenDTO implements DTO {
    @NotEmpty
    private String username;
    @NotEmpty
    private String token;

    public UsernameTokenDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsernameTokenDTO(@NotEmpty String username, @NotEmpty String token) {
        this.username = username;
        this.token = token;
    }
}
