package com.helha.listecourses.command.shopping;

import com.helha.listecourses.command.ICommandHandler;
import com.helha.listecourses.infrastructure.product.DbProduct;
import com.helha.listecourses.infrastructure.product.IProductRepository;
import com.helha.listecourses.infrastructure.shopping.DbShoppingItem;
import com.helha.listecourses.infrastructure.shopping.IShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //
public class CreateShoppingItemHandler implements ICommandHandler<CreateShoppingItemInput, Void> {

    @Autowired
    private IShoppingRepository repository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Void handle(CreateShoppingItemInput input) {
        DbShoppingItem item = new DbShoppingItem();

        // On récupère le produit
        DbProduct product = productRepository.findById(input.getProductId())
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        item.setProduct(product);
        item.setQuantity(input.getQuantity());

        repository.save(item); //
        return null;
    }
}