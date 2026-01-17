package com.helha.listecourses.application.product.query.getAll;

import com.helha.listecourses.application.utils.IQueryHandler;
import com.helha.listecourses.infrastructure.product.DbProduct;
import com.helha.listecourses.infrastructure.product.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList; // Très important pour ne pas avoir d'erreur !
import java.util.List;

@Service
// On utilise GetAllProductsInput au lieu de Void pour être fidèle au prof
public class GetAllProductsHandler implements IQueryHandler<GetAllProductsInput, List<GetAllProductsOutput>> {

    @Autowired
    private IProductRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<GetAllProductsOutput> handle(GetAllProductsInput input) {
        // 1. On crée une liste VIDE au début (ArrayList)
        List<GetAllProductsOutput> outputs = new ArrayList<>();

        // 2. On récupère les données brutes de MySQL
        Iterable<DbProduct> dbProducts = repository.findAll();

        // 3. LA BOUCLE FOR (comme dans Todo) :
        // Pour chaque produit trouvé dans la base...
        for (DbProduct dbProduct : dbProducts) {
            // ...on le transforme en "Output" et on l'ajoute à notre liste
            outputs.add(mapper.map(dbProduct, GetAllProductsOutput.class));
        }

        // 4. On renvoie la liste remplie
        return outputs;
    }
}