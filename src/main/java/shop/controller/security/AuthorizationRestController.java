package shop.controller.security;


import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dtos.message.Message;
import shop.dtos.security.UsernameTokenDTO;
import shop.service.customer.AuthorizationService;
import shop.service.security.TokenParserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/authorization/is-available/")
public class AuthorizationRestController {

    private AuthorizationService authorizationService;
    private TokenParserService tokenParserService;

    @Autowired
    public void setTokenParserService(TokenParserService tokenParserService) {
        this.tokenParserService = tokenParserService;
    }

    @Autowired
    public void setAuthorizationService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("cart")
    public Message cartAvailableCheck(@RequestBody UsernameTokenDTO usernameTokenDTO,
                                      HttpServletRequest request) throws JwtException {
        usernameTokenDTO.setToken(tokenParserService.getTokenFromHeader(request));
        return new Message(!authorizationService.isAuthenticated(usernameTokenDTO), "");
    }

}