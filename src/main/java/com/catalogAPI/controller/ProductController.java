package com.catalogAPI.controller;

import com.catalogAPI.domain.Product;
import com.catalogAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @RequestMapping("/api/products")
    public ResponseEntity<Map<String, List<Product>>> getAllProducts() {
        List<Product> allProducts = this.productService.getAllProducts();

        Map<String, List<Product>> response = new HashMap<>();
        response.put("products", allProducts);
        return ResponseEntity.ok(response);
    }
    @RequestMapping("/api/products/category/{category}")
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

