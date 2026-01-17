package com.helha.listecourses.command.product.create;

import com.helha.listecourses.infrastructure.product.DbProduct;
import com.helha.listecourses.infrastructure.product.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductHandler {
    @Autowired
    private IProductRepository repository;

    @Autowired
    private ModelMapper mapper;

    public DbProduct handle(CreateProductInput input) {
        // Transforme l'input en objet pour la base de données
        DbProduct toSave = mapper.map(input, DbProduct.class);
        // Sauvegarde dans MySQL
        return repository.save(toSave);
    }
}