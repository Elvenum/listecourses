package com.helha.listecourses.controllers.category;

import com.helha.listecourses.application.category.CategoryProcessor;
import com.helha.listecourses.application.category.query.getAll.GetAllCategoryInput;
import com.helha.listecourses.application.category.query.getAll.GetAllCategoryOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {


    @Autowired
    private CategoryProcessor processor;

    @GetMapping // Cette annotation dit que c'est une requête GET
    public GetAllCategoryOutput getAll() {
        return processor.getAll(new GetAllCategoryInput());
    }
}
