package com.helha.listecourses.application.product.query;

import com.helha.listecourses.application.product.query.getAll.GetAllProductsHandler;
import com.helha.listecourses.application.product.query.getAll.GetAllProductsInput;
import com.helha.listecourses.application.product.query.getAll.GetAllProductsOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Indispensable pour que Spring le reconnaisse
public class ProductQueryProcessor {

    @Autowired
    private GetAllProductsHandler getAllHandler;

    public GetAllProductsOutput getAll(GetAllProductsInput input) {
        // Il appelle simplement le handler qu'on a modifié tout à l'heure
        return getAllHandler.handle(input);
    }
}