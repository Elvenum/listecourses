package com.helha.listecourses.command.shopping;

import lombok.Data;

@Data
public class CreateShoppingItemInput {
    private Long productId; // Quel produit on ajoute
    private Double quantity;
}