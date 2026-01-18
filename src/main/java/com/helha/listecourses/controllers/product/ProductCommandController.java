package com.helha.listecourses.controllers.product;

import com.helha.listecourses.command.product.ProductCommandProcessor;
import com.helha.listecourses.command.product.create.CreateProductInput;
import com.helha.listecourses.command.product.update.UpdateProductInput;
import com.helha.listecourses.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    @Autowired
    private ProductCommandProcessor processor;

    @PostMapping
    // Correction : On renvoie "Product" (le domaine) et pas "DbProduct"
    public Product create(@RequestBody CreateProductInput input) {
        return processor.createHandler.handle(input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        processor.delete(id);
    }

    @PutMapping
    // Correction ici aussi : le handler d'update renvoie un "Product"
    public Product update(@RequestBody UpdateProductInput input) {
        return processor.update(input);
    }
}