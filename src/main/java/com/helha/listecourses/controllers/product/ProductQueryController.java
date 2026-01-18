package com.helha.listecourses.controllers.product;

import com.helha.listecourses.application.product.query.ProductQueryProcessor;
import com.helha.listecourses.application.product.query.getAll.GetAllProductsInput;
import com.helha.listecourses.application.product.query.getAll.GetAllProductsOutput;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products") // Même URL que le command controller, mais pour le GET
public class ProductQueryController {

    @Autowired
    private ProductQueryProcessor processor;


    @GetMapping
    public GetAllProductsOutput getAll(@ParameterObject GetAllProductsInput input) {
        // L'ajout de @ParameterObject va "exploser" le bloc JSON en cases séparées
        return processor.getAll(input);
    }
}