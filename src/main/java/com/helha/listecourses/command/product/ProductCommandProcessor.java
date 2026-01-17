package com.helha.listecourses.command.product;

import com.helha.listecourses.command.product.create.CreateProductHandler;
import com.helha.listecourses.command.product.delete.DeleteProductHandler;
import com.helha.listecourses.command.product.update.UpdateProductHandler;
import com.helha.listecourses.command.product.update.UpdateProductInput;
import com.helha.listecourses.infrastructure.product.DbProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandProcessor {
    @Autowired
    public CreateProductHandler createHandler;

    @Autowired
    public DeleteProductHandler deleteHandler;

    public void delete(Long id){
        deleteHandler.handle(id);
    }

    @Autowired
    private UpdateProductHandler updateHandler; // Utilise private par habitude

    // On change (Long id) par (UpdateProductInput input)
    public DbProduct update(UpdateProductInput input) {
        return updateHandler.handle(input);
    }
}