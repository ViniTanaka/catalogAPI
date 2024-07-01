package com.catalogAPI.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Array;
import java.math.BigDecimal;

@Entity
@Table(name= "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String images;
    private String measure;
    @Getter
    @Setter
    private String category;
    private BigDecimal price;
    private BigDecimal weight;

}
