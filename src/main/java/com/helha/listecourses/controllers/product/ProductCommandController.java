package com.helha.listecourses.controllers.product;

import com.helha.listecourses.command.product.ProductCommandProcessor;
import com.helha.listecourses.command.product.create.CreateProductInput;
import com.helha.listecourses.command.product.update.UpdateProductInput;
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


    @DeleteMapping("/{id}") // L'URL sera /api/products/1 (si l'ID est 1)
    public void delete(@PathVariable Long id) {
        processor.delete(id);
    }

    @PutMapping // L'URL reste /api/products
    public DbProduct update(@RequestBody UpdateProductInput input) {
        // On renvoie le résultat du processor pour que Swagger l'affiche
        return processor.update(input);
    }
}