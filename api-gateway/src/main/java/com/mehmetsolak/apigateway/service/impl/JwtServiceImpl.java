package com.mehmetsolak.apigateway.service.impl;

import com.mehmetsolak.apigateway.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${spring.security.jwt-filter.secret-key}")
    private static String secretKey;

    @Override
    public boolean isTokenValid(String jwt) {
        final Date tokenExpirationDate = extractClaim(jwt, Claims::getExpiration);
        return tokenExpirationDate.before(new Date());
    }

    private <T> T extractClaim(String jwt, Function<Claims, T> claimsExtractor) {
        final Claims claims = parseJwt(jwt);
        return claimsExtractor.apply(claims);
    }

    private Claims parseJwt(String jwt) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    private Key getSigningKey() {
        final byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
