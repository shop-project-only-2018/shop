package shop.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private TokenService tokenService;

    @Autowired
    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

//    private UserDetailsMapper mapper;
//    @Autowired
//    public void setMapper(UserDetailsMapper mapper) {
//        this.mapper = mapper;
//    }


    /**
     * Getting used token type from token service.
     *
     * @return tokenType
     */
    public String getTokenType() {
        return tokenService.getTokenType();
    }


//    /**
//     * Returns JWT by UserDetails.
//     *
//     * @param identifiedUserDetails - user data
//     * @return encoded json
//     */
//    public String login(IdentifiedUserDetails identifiedUserDetails) throws JwtException {
//        return tokenService.generate(mapper.toMap(identifiedUserDetails));
//    }
//
//    /**
//     * Returns UserDetails by JWT.
//     *
//     * @param token - encoded json
//     * @return user data
//     */
//    public IdentifiedUserDetails authentication(String token) throws JwtException {
//        return mapper.toIdentifiedUserDetails(tokenService.verify(token));
//    }
}
