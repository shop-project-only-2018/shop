package shop.dtos.security;

import shop.dtos.DTO;

import java.net.URI;

public class LoginDTO implements DTO {

    private String username;
    private URI userURI;

    public LoginDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LoginDTO(String username, URI userURI) {
        this.username = username;
        this.userURI = userURI;
    }

    public URI getUserURI() {
        return userURI;
    }

    public LoginDTO setUserURI(URI userURI) {
        this.userURI = userURI;
        return this;
    }
}
