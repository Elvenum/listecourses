package com.helha.listecourses.command.category.delete;

import com.helha.listecourses.infrastructure.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryHandler {

    @Autowired
    private ICategoryRepository categoryRepository;

    public void handle(Long id)
    {
        categoryRepository.deleteById(id);
    }
}
