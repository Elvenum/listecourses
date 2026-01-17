package com.helha.listecourses.application.category.query.getAll;


import com.helha.listecourses.application.product.query.getAll.GetAllProductsInput;
import com.helha.listecourses.application.utils.IQueryHandler;
import com.helha.listecourses.domain.Category;
import com.helha.listecourses.infrastructure.category.DbCategory;
import com.helha.listecourses.infrastructure.category.ICategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// 1. On précise <Input, Output> ici pour remplir le contrat
public class GetAllCategoryHandler implements IQueryHandler<GetAllCategoryInput, GetAllCategoryOutput> {

    @Autowired
    private ICategoryRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    // 2. On utilise bien GetAllCategoryInput ici
    public GetAllCategoryOutput handle(GetAllCategoryInput input)
    {
        GetAllCategoryOutput output = new GetAllCategoryOutput();

        // On récupère les DbCategory
        Iterable<DbCategory> dbCategories = repository.findAll();

        for(DbCategory dbCategory : dbCategories)
        {
            // On transforme DbCategory (Infrastructure) en Category (Domain)
            output.categories.add(mapper.map(dbCategory, Category.class));
        }
        return output;
    }
}

