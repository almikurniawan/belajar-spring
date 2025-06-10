package com.belajar.sales.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.belajar.sales.config.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    @Autowired
    private JwtProperties jwtProperties;

    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withClaim("role", "administrator")
                .withClaim("role", "approver")
                .withIssuedAt(new Date())
                .withIssuer(jwtProperties.getIssuer())
                .withAudience(jwtProperties.getAudience())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .sign(Algorithm.HMAC256(jwtProperties.getSecret()));
    }

    public String extractUsername(String token) {
        return JWT.require(Algorithm.HMAC256(jwtProperties.getSecret()))
                .build()
                .verify(token)
                .getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            JWT.require(Algorithm.HMAC256(jwtProperties.getSecret())).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
