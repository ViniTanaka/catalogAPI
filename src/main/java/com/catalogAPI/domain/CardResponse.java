package com.catalogAPI.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "card")
@AllArgsConstructor
@NoArgsConstructor
public class CardResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String response;
    private String message;
}
