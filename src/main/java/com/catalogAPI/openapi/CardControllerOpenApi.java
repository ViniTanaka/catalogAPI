package com.catalogAPI.openapi;

import com.catalogAPI.domain.Card;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Tag(name="CardNumber")
public interface CardControllerOpenApi {
    @Operation(summary = "Decode cardNumber")
    ResponseEntity<Map<String, String>> postCardNumber(Card card);
}
