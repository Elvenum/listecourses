package com.helha.listecourses.command.product.update;

import lombok.Data;


@Data
public class UpdateProductInput {
    private Long id; // Obligatoire pour savoir quel produit modifier
    private String name;
    private Long categoryId;
    private Long storeId;
}
