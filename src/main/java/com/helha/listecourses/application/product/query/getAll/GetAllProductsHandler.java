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
        GetAllProductsOutput output = new GetAllProductsOutput();
        Iterable<DbProduct> dbProducts;

        // 1. CAS LE PLUS PRÉCIS : On a les deux (Magasin + Catégorie)
        if (input.getStoreId() != null && input.getCategoryId() != null) {
            dbProducts = repository.findByStoreIdAndCategoryId(input.getStoreId(), input.getCategoryId());
        }
        // 2. CAS INTERMÉDIAIRE : On n'a que le magasin
        else if (input.getStoreId() != null) {
            dbProducts = repository.findByStoreId(input.getStoreId());
        }
        // 3. CAS INTERMÉDIAIRE : On n'a que la catégorie
        else if (input.getCategoryId() != null) {
            dbProducts = repository.findByCategoryId(input.getCategoryId());
        }
        // 4. CAS PAR DÉFAUT : On n'a rien, on renvoie tout
        else {
            dbProducts = repository.findAll();
        }

        // Transformation en objets du Domaine
        for (DbProduct dbProduct : dbProducts) {
            output.products.add(mapper.map(dbProduct, Product.class));
        }
        return output;
    }
}


//@Service
//public class GetAllProductsHandler implements IQueryHandler<GetAllProductsInput, GetAllProductsOutput> {
//
//    @Autowired
//    private IProductRepository repository;
//
//    @Autowired
//    private ModelMapper mapper;
//
//    @Override
//    public GetAllProductsOutput handle(GetAllProductsInput input) {
//        // 1. On crée la "boîte" de sortie
//        GetAllProductsOutput output = new GetAllProductsOutput();
//
//        // 2. On récupère les données brutes
//        Iterable<DbProduct> dbProducts = repository.findAll();
//
//        // 3. On remplit la liste à l'intérieur de la boîte
//        for (DbProduct dbProduct : dbProducts) {
//            // Note : on transforme ici vers la classe "Product" du Domain
//            output.products.add(mapper.map(dbProduct, Product.class));
//        }
//
//        return output;
//    }
//}