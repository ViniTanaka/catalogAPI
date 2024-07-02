package com.catalogAPI.utils;

import com.catalogAPI.domain.Card;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JwtUtils {

    private final SecretKey secretKey;

    public JwtUtils(@Value("${jwt.secret}") String secret) {
        // Converte a string do application.properties para um array de bytes UTF-8
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        // Cria uma chave segura usando a classe Keys
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims verify(Card card) throws JwtException {
        String cardEncode = card.getCardEncode();
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(cardEncode).getBody();
            return claims;
        } catch (JwtException e) {
            // Logar ou relançar a exceção para tratamento adequado
            throw new JwtException("Token JWT inválido ou expirado", e);
        }
    }
}
