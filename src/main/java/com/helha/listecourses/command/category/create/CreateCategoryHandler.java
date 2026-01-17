package com.helha.listecourses.command.category.create;


import com.helha.listecourses.infrastructure.category.DbCategory;
import com.helha.listecourses.infrastructure.category.ICategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryHandler {

    @Autowired
    private ICategoryRepository repository;

    @Autowired
    private ModelMapper mapper;

    public DbCategory handle(CreateCategoryInput input) {

        DbCategory toSave = mapper.map(input, DbCategory.class);

        return repository.save(toSave);
    }
}
