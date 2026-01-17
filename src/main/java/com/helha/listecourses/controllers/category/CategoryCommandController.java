package com.helha.listecourses.controllers.category;

import com.helha.listecourses.command.category.CategoryCommandProcessor;
import com.helha.listecourses.command.category.create.CreateCategoryInput;
import com.helha.listecourses.command.category.update.UpdateCategoryInput;
import com.helha.listecourses.infrastructure.category.DbCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryCommandController {

    @Autowired
    private CategoryCommandProcessor processor;

    @PostMapping
    public DbCategory create(@RequestBody CreateCategoryInput input) {
        return processor.createHandler.handle(input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        processor.delete(id);
    }

    @PutMapping
    public DbCategory update(@RequestBody UpdateCategoryInput input) {
        return processor.update(input);
    }


}
