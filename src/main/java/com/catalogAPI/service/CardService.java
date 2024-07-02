package com.catalogAPI.service;

import com.catalogAPI.domain.Card;
import com.catalogAPI.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtUtils jwtUtils;

    public Claims postCardNumber(Card card) {
        Claims claims = null;
        try {
            claims = jwtUtils.verify(card);
        } catch (Exception e) {
            // Handle the exception as necessary
            e.printStackTrace();
        }
        // Use the claims variable for further processing
        return claims;
    }
}
