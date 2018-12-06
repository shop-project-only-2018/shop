package shop.dtos.security;


import shop.dtos.DTO;

public class TokenDTO implements DTO {

    private String accessToken;
    private String tokenType;


    public String getAccessToken() {
        return accessToken;
    }

    public TokenDTO setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getTokenType() {
        return tokenType;
    }

    public TokenDTO setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

}
