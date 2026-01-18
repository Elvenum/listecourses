package com.helha.listecourses.command.product;

import com.helha.listecourses.command.product.create.CreateProductHandler;
import com.helha.listecourses.command.product.create.CreateProductInput;
import com.helha.listecourses.command.product.delete.DeleteProductHandler;
import com.helha.listecourses.command.product.delete.DeleteProductInput;
import com.helha.listecourses.command.product.update.UpdateProductHandler;
import com.helha.listecourses.command.product.update.UpdateProductInput;
import com.helha.listecourses.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Indispensable pour que Spring gère cette classe
public class ProductCommandProcessor {

    @Autowired
    public CreateProductHandler createHandler;

    @Autowired
    public UpdateProductHandler updateHandler;

    @Autowired
    public DeleteProductHandler deleteHandler;

    /**
     * Appelle le handler pour la création
     */
    public Product create(CreateProductInput input) {
        return createHandler.handle(input);
    }

    /**
     * Appelle le handler pour la mise à jour
     */
    public Product update(UpdateProductInput input) {
        return updateHandler.handle(input);
    }

    /**
     * Appelle le handler pour la suppression
     */
    public void delete(Long id) {
        // On prépare l'objet Input attendu par le DeleteProductHandler
        DeleteProductInput input = new DeleteProductInput();
        input.setId(id);
        deleteHandler.handle(input);
    }
}