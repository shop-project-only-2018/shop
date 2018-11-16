package shop.dtos.security;

import shop.dtos.DTO;

import java.net.URI;

public class LoginDTO implements DTO {

    private String login;
    private URI userURI;

    public String getLogin() {
        return login;
    }

    public LoginDTO setLogin(String login) {
        this.login = login;
        return this;
    }

    public URI getUserURI() {
        return userURI;
    }

    public LoginDTO setUserURI(URI userURI) {
        this.userURI = userURI;
        return this;
    }
}
