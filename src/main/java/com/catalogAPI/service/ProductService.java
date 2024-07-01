package com.catalogAPI.service;

import com.catalogAPI.domain.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ObjectMapper objectMapper;

    public List<Product> getAllProducts() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/productsCatalog.JSON");
            Map<String, Object> responseMap = objectMapper.readValue(inputStream, new TypeReference<Map<String, Object>>() {});
            List<Product> products = objectMapper.convertValue(responseMap.get("products"), new TypeReference<List<Product>>() {});
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            // Trate o erro conforme necessário
            return null;
        }
    }

    public List<Product> getProductsByCategory(String category) {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/productsCatalog.JSON");
            Map<String, Object> responseMap = objectMapper.readValue(inputStream, new TypeReference<Map<String, Object>>() {
            });
            List<Product> products = objectMapper.convertValue(responseMap.get("products"), new TypeReference<List<Product>>() {
            });
            return products.stream()
                    .filter(product -> product.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            // Trate o erro conforme necessário
            return null;
        }
    }
}
