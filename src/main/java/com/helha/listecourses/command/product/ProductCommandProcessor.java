package com.helha.listecourses.command.product;

import com.helha.listecourses.command.product.create.CreateProductHandler;
import com.helha.listecourses.command.product.delete.DeleteProductHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandProcessor {
    @Autowired
    public CreateProductHandler createHandler;

    @Autowired
    public DeleteProductHandler deleteHandler;

    public void delete(Long id){
        deleteHandler.handle(id);
    }
}