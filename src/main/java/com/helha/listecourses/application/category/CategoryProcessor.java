package com.helha.listecourses.application.category;

import com.helha.listecourses.application.category.query.getAll.GetAllCategoryHandler;
import com.helha.listecourses.application.category.query.getAll.GetAllCategoryInput;
import com.helha.listecourses.application.category.query.getAll.GetAllCategoryOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryProcessor {

    @Autowired
    private GetAllCategoryHandler getAllHandler;

    // Modifier la signature de la méthode
    public GetAllCategoryOutput getAll(GetAllCategoryInput input) {
        return getAllHandler.handle(input);
    }
}
