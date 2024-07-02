package com.catalogAPI.controller;

import com.catalogAPI.domain.Product;
import com.catalogAPI.openapi.ProductControllerOpenApi;
import com.catalogAPI.service.ProductService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/products")
public class ProductController implements ProductControllerOpenApi {

    @Autowired
    private ProductService productService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping
    public ResponseEntity<Map<String, List<Product>>> getAllProducts() {
        List<Product> allProducts = this.productService.getAllProducts();

        Map<String, List<Product>> response = new HashMap<>();
        response.put("products", allProducts);
        return ResponseEntity.ok(response);
    }
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/api/products/category/{category}")
    public ResponseEntity<Map<String, List<Product>>> getProductByCategory(@PathVariable(value = "category") String category) {
        List<Product> filteredProducts;
        if (category != null && !category.isEmpty()) {
            filteredProducts = this.productService.getProductsByCategory(category);
        } else {
            filteredProducts = this.productService.getAllProducts();
        }

        Map<String, List<Product>> response = new HashMap<>();
        response.put("products", filteredProducts);

        return ResponseEntity.ok(response);
    }
}

