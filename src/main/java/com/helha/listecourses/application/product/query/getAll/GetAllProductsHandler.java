package com.helha.listecourses.application.product.query.getAll;

import com.helha.listecourses.application.utils.IQueryHandler;
import com.helha.listecourses.domain.Product;
import com.helha.listecourses.infrastructure.product.DbProduct;
import com.helha.listecourses.infrastructure.product.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllProductsHandler implements IQueryHandler<GetAllProductsInput, GetAllProductsOutput> {

    @Autowired
    private IProductRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public GetAllProductsOutput handle(GetAllProductsInput input) {
        // 1. On crée la "boîte" de sortie
        GetAllProductsOutput output = new GetAllProductsOutput();

        // 2. On récupère les données brutes
        Iterable<DbProduct> dbProducts = repository.findAll();

        // 3. On remplit la liste à l'intérieur de la boîte
        for (DbProduct dbProduct : dbProducts) {
            // Note : on transforme ici vers la classe "Product" du Domain
            output.products.add(mapper.map(dbProduct, Product.class));
        }

        return output;
    }
}