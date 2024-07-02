package com.catalogAPI.controller;

import com.catalogAPI.domain.Card;
import com.catalogAPI.service.CardService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    @RequestMapping("/api/cards")
    public ResponseEntity<Map<String, String>> postCardNumber(@RequestBody Card card) {
        try {
            Claims claims = this.cardService.postCardNumber(card);

            Map<String, String> response = new HashMap<>();
            response.put("response", "200");
            response.put("message", "Approved");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
