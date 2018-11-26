package shop.controller.security;


import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import shop.dtos.message.Message;
import shop.dtos.security.TokenDTO;
import shop.dtos.security.UsernamePasswordDTO;
import shop.dtos.security.UsernameTokenDTO;
import shop.service.customer.AuthorizationService;
import shop.service.customer.CustomerService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/authorization/is-available/")
public class AuthorizationRestController {
    private String tokenType;
    @Value("${security.tokenType}")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    private AuthorizationService authorizationService;
        @Autowired
    public void setAuthorizationService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("cart")
    public Message cartAvailableCheck(@RequestBody UsernameTokenDTO usernameTokenDTO,
                                      HttpServletRequest request) throws JwtException {
        String token;
        String credentials = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (credentials == null) {
            throw new BadCredentialsException("error.security.badToken");
        } else if (!credentials.startsWith(tokenType)) {
            throw new BadCredentialsException("error.security.badToken");
        } else {
            token = credentials.substring(tokenType.length()).trim();
        }
        usernameTokenDTO.setToken(token);
        return new Message(!authorizationService.isAuthenticated(usernameTokenDTO), "");
    }

}