package com.helha.listecourses.command.product.create;

import lombok.Data;

@Data
public class CreateProductInput {
    private String name;
    private Long categoryId;
    private Long storeId;
}