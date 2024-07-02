package com.catalogAPI.controller;

import com.catalogAPI.domain.Card;
import com.catalogAPI.domain.CardResponse;
import com.catalogAPI.domain.Product;
import com.catalogAPI.openapi.CardControllerOpenApi;
import com.catalogAPI.service.CardService;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/cards")
public class CardController implements CardControllerOpenApi {

    @Autowired
    private CardService cardService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CardResponse.class)))
    })
    @PostMapping
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
