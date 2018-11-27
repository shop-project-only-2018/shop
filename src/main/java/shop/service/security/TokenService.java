package shop.service.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Service
public class TokenService implements Clock {

    private static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

    private String tokenType;
    private String issuer;
    private String sign;

    public String getTokenType() {
        return tokenType;
    }

    @Value("${security.tokenType}")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Value("${security.issuer}")
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Value("${security.sign}")
    public void setSign(String sign) {
        this.sign = sign;
    }

    @PostConstruct
    private void init() {
        sign = TextCodec.BASE64.encode(sign);
    }


    public String generate(final Map<String, Object> attributes) throws JwtException {
        final Claims claims = Jwts
                .claims(attributes)
                .setIssuer(issuer)
                .setIssuedAt(now());

        return Jwts
                .builder()
                .setClaims(claims)
                .signWith(signatureAlgorithm, sign)
                .compact();
    }

    public Map<String, Object> verify(final String token) throws JwtException {
        return Jwts
                .parser()
                .requireIssuer(issuer)
                .setSigningKey(sign)
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public Date now() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }
}
