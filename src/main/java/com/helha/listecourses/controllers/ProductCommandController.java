package com.helha.listecourses.controllers;

import com.helha.listecourses.command.product.ProductCommandProcessor;
import com.helha.listecourses.command.product.create.CreateProductInput;
import com.helha.listecourses.infrastructure.product.DbProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products") // L'URL sera http://localhost:8080/api/products
public class ProductCommandController {

    @Autowired
    private ProductCommandProcessor processor;

    @PostMapping // On utilise POST pour créer
    public DbProduct create(@RequestBody CreateProductInput input) {
        return processor.createHandler.handle(input);
    }
}