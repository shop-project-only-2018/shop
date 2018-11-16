package shop.service.security;

import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.mappers.customer.CustomerDetailsMapper;
import shop.service.security.userdetails.IdentifiedUserDetails;

@Service
public class SecurityService {

    private TokenService tokenService;

    @Autowired
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    private CustomerDetailsMapper customerDetailsMapper;
    @Autowired
    public void setCustomerDetailsMapper(CustomerDetailsMapper customerDetailsMapper) {
        this.customerDetailsMapper = customerDetailsMapper;
    }


    /**
     * Getting used token type from token service.
     *
     * @return tokenType
     */
    public String getTokenType() {
        return tokenService.getTokenType();
    }


    public String login(IdentifiedUserDetails identifiedUserDetails) throws JwtException {
        return tokenService.generate(customerDetailsMapper.toMap(identifiedUserDetails));
    }

    public IdentifiedUserDetails authentication(String token) throws JwtException {
        return customerDetailsMapper.toIdentifiedCustomerDetails(tokenService.verify(token));
    }
}
