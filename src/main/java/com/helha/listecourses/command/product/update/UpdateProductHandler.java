package com.helha.listecourses.command.product.update;

import com.helha.listecourses.infrastructure.product.DbProduct;
import com.helha.listecourses.infrastructure.product.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UpdateProductHandler {

    @Autowired
    private IProductRepository repository;

    @Autowired
    private ModelMapper mapper;

    public DbProduct handle(UpdateProductInput input) {
        // 1. On cherche le produit existant dans Docker
        Optional<DbProduct> existingProduct = repository.findById(input.getId());

        if (existingProduct.isPresent()) {
            DbProduct productToUpdate = existingProduct.get();

            // 2. On "écrase" les anciennes valeurs par les nouvelles
            // ModelMapper va copier le nom et la catégorie de l'input vers le produit
            mapper.map(input, productToUpdate);

            // 3. On sauvegarde le produit mis à jour
            return repository.save(productToUpdate);
        }

        // Si le produit n'existe pas, on pourrait renvoyer null ou une erreur
        return null;
    }
}