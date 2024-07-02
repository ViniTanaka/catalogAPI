package com.catalogAPI.openapi;

import com.catalogAPI.domain.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

@Tag(name="Products")
public interface ProductControllerOpenApi {
    @Operation(summary = "Get All Products")
    ResponseEntity<Map<String, List<Product>>> getAllProducts();
    @Operation(summary = "Get All Products by Categories")
    ResponseEntity<Map<String, List<Product>>> getProductByCategory(String category);
}
