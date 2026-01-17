package com.helha.listecourses.command.category.update;


import com.helha.listecourses.infrastructure.category.DbCategory;
import com.helha.listecourses.infrastructure.category.ICategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCategoryHandler {

    @Autowired
    private ICategoryRepository repository;

    @Autowired
    private ModelMapper mapper;


    public DbCategory handle(UpdateCategoryInput input)
    {
        Optional<DbCategory> existingCategory = repository.findById(input.getId());

        if(existingCategory.isPresent())
        {
            DbCategory productToUpdate = existingCategory.get();

            mapper.map(input , productToUpdate);

            return repository.save(productToUpdate);
        }

        return null;
    }

}
