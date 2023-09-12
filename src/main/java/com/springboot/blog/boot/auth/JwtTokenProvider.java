package com.springboot.blog.boot.auth;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SignatureException;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.token-validity-in-seconds}")
    private long jwtExpirationDate;

    // generate JWT Token
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();

        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + (1000L * 60 * 60 * 24 * 7));

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setIssuer("blog")
                .setExpiration(expireDate)
                .signWith(key())
                .compact();

        return token;
    }

    // get username from JWT Token
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // validate JWT Token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parseClaimsJws(token);

            return true;

        } catch (ExpiredJwtException e) {
            log.error("만료된 토큰입니다. msg=" + e.getMessage());
            throw new ExpiredJwtException(null, null, "만료된 토큰입니다. msg=" + e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("지원하지 않는 토큰 형식입니다. msg=" + e.getMessage());
            throw new UnsupportedJwtException("지원하지 않는 토큰 형식입니다. msg=" + e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("유효하지 않는 토큰입니다. msg=" + e.getMessage());
            throw new MalformedJwtException("유효하지 않는 토큰입니다. Refresh Token 을 활용한 재갱신이 필요합니다. msg=" + e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("유효하지 않은 인자입니다. msg=" + e.getMessage());
            throw new IllegalArgumentException("유효하지 않은 인자입니다. msg=" + e.getMessage());
        }
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
}













