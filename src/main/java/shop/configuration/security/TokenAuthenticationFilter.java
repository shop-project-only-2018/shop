package shop.configuration.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private String tokenType;

    protected TokenAuthenticationFilter(RequestMatcher requestMatcher) {
        super(requestMatcher);
    }

    @Value("${security.tokenType}")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws AuthenticationException {
        final String token;
        final String credentials = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (credentials == null) {
            throw new BadCredentialsException("error.security.badToken");
        } else if (!credentials.startsWith(tokenType)) {
            throw new BadCredentialsException("error.security.badToken");
        } else {
            token = credentials.substring(tokenType.length()).trim();
        }
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(null, token));
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain, Authentication authResult
    ) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
