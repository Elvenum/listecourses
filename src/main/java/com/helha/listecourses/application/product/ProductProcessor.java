package com.helha.listecourses.application.product;

import com.helha.listecourses.application.product.query.getAll.GetAllProductsHandler;
import com.helha.listecourses.application.product.query.getAll.GetAllProductsInput;
import com.helha.listecourses.application.product.query.getAll.GetAllProductsOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductProcessor {

    @Autowired
    private GetAllProductsHandler getAllHandler;

    // Cette méthode sera appelée par le Controller
    public List<GetAllProductsOutput> getAll(GetAllProductsInput input) {
        return getAllHandler.handle(input);
    }
}