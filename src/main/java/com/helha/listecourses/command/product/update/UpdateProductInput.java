package com.helha.listecourses.command.product.update;

import lombok.Data;

@Data
public class UpdateProductInput {
    private Long id;
    private String name;
    private String category;
}
