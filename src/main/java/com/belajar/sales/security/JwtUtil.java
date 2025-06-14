package com.belajar.sales.security;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.belajar.sales.config.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
    @Autowired
    private JwtProperties jwtProperties;

    public String generateToken(String username) {
        List<String> roles = Arrays.asList("ADMIN", "USER");

        return JWT.create()
                .withSubject(username)
                .withClaim("role", roles)
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

    public List<SimpleGrantedAuthority> extractAuthorities(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecret());
            JWTVerifier verifier = JWT.require(algorithm)
                    .build(); // default: verify signature + expiration (if any)

            DecodedJWT jwt = verifier.verify(token);
            var role = jwt.getClaim("role").asList(SimpleGrantedAuthority.class);
            return role;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
