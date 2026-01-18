package com.helha.listecourses.domain;

import lombok.Data;

@Data
public class ShoppingItem {
    private Long id;
    private Product product; // Pour avoir le nom du produit et sa catégorie
    private Double quantity;
    private boolean isBought;
}