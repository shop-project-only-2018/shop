package shop.service.security;

import com.google.common.net.HttpHeaders;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import shop.system.CheckedException;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenParserService {

    private String tokenType;

    // TODO: REMOVE // IMPLEMENT SecurityContextHolder
    @Value("${security.tokenType}")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenFromHeader(HttpServletRequest request) throws CheckedException {
        String token;
        String credentials = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (credentials == null) {
            throw new CheckedException("error.security.badToken");
        } else if (!credentials.startsWith(tokenType)) {
            throw new CheckedException("error.security.badToken");
        } else {
            token = credentials.substring(tokenType.length()).trim();
        }
        return token;
    }

}
