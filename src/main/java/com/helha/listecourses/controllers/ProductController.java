package com.helha.listecourses.controllers;

import com.helha.listecourses.application.product.ProductProcessor;
import com.helha.listecourses.application.product.query.getAll.GetAllProductsInput;
import com.helha.listecourses.application.product.query.getAll.GetAllProductsOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductProcessor processor;

    @GetMapping // Cette annotation dit que c'est une requête GET
    public GetAllProductsOutput getAll() {
        return processor.getAll(new GetAllProductsInput());
    }
}