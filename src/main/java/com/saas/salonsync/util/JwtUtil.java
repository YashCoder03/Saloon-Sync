package com.saas.salonsync.util;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private final Key key;
    private final long jwtExpirationms;

    public JwtUtil(@Value("${jwt.secret}") String secret ,
                    @Value("${jwt.expiration-ms}") long jwtExpirationms){
                        this.key = Keys.hmacShaKeyFor(secret.getBytes());
                        this.jwtExpirationms = jwtExpirationms;
                    }

    public String generateToken(String userName) {
        Date date = new Date();
        Date expiryDate = new Date(date.getTime() + jwtExpirationms);

        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(date)
                .setExpiration(expiryDate)
                .signWith(key,SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }


}
