package com.helha.listecourses.application.shopping.query.getAll;

import com.helha.listecourses.application.utils.IQueryHandler;
import com.helha.listecourses.domain.ShoppingItem;
import com.helha.listecourses.infrastructure.shopping.DbShoppingItem;
import com.helha.listecourses.infrastructure.shopping.IShoppingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllShoppingHandler implements IQueryHandler<GetAllShoppingInput, GetAllShoppingOutput> {

    @Autowired
    private IShoppingRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public GetAllShoppingOutput handle(GetAllShoppingInput input) {
        GetAllShoppingOutput output = new GetAllShoppingOutput();

        // Récupération de toute la liste
        Iterable<DbShoppingItem> dbItems = repository.findAll();

        for (DbShoppingItem dbItem : dbItems) {
            output.items.add(mapper.map(dbItem, ShoppingItem.class));
        }

        return output;
    }
}