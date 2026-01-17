package com.helha.listecourses.command.category;

import com.helha.listecourses.command.category.create.CreateCategoryHandler;
import com.helha.listecourses.command.category.delete.DeleteCategoryHandler;
import com.helha.listecourses.command.category.update.UpdateCategoryHandler;
import com.helha.listecourses.command.category.update.UpdateCategoryInput;
import com.helha.listecourses.infrastructure.category.DbCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryCommandProcessor {

    @Autowired
    public CreateCategoryHandler createHandler;

    @Autowired
    public DeleteCategoryHandler deleteHandler;

    public void  delete(Long id)
    {
        deleteHandler.handle(id);
    }

    @Autowired
    private UpdateCategoryHandler updateHandler;

    public DbCategory update(UpdateCategoryInput input) {
        return updateHandler.handle(input);
    }
}
