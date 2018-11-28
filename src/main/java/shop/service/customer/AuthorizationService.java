package shop.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dtos.security.UsernameTokenDTO;
import shop.service.security.SecurityService;

@Service
public class AuthorizationService {

    private SecurityService securityService;

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    public Boolean isAuthenticated(UsernameTokenDTO usernameTokenDTO) {
        return usernameTokenDTO.getUsername()
                .equals(securityService.checkTokenGetUsername(usernameTokenDTO.getToken()));
    }
}
