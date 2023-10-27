package com.example.jwtspring_security.SIMPLE_JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtToken {
    public static String generateToken(String userName, String key, long expiredTimeMs) {
        Claims claims = Jwts.claims();
        claims.put("username", userName);

        return Jwts.builder()
                .setClaims(claims) // 정보 유저이름 (중요 하지않은 정보 넣는게 좋음)
                .setIssuedAt(new Date(System.currentTimeMillis())) //토큰 발행시간
                .setExpiration(new Date(System.currentTimeMillis() + expiredTimeMs)) // 토큰 만료시간
                .signWith(getKey(key), SignatureAlgorithm.HS256)
                .compact();
    }
    private static Key getKey(String key) {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
