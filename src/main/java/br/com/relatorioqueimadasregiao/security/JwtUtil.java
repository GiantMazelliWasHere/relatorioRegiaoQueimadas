package br.com.relatorioqueimadasregiao.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtil {
    private static final SecretKey SECRET_KEY;

    public static String gerarToken(String username, String role) {
        return Jwts.builder().subject(username).claim("role", role).expiration(new Date(System.currentTimeMillis() + 86400000L)).signWith(SECRET_KEY, SIG.HS256).compact();
    }

    public static Claims validarToken(String token) {
        JwtParser parser = Jwts.parser().verifyWith(SECRET_KEY).build();
        return (Claims)parser.parseSignedClaims(token).getPayload();
    }

    static {
        SECRET_KEY = Keys.hmacShaKeyFor("MinhaChaveSecretaSegura1234567890123456".getBytes(StandardCharsets.UTF_8));
    }
}
