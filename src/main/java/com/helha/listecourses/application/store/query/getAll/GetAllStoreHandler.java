package com.helha.listecourses.application.store.query.getAll;

import com.helha.listecourses.application.utils.IQueryHandler;
import com.helha.listecourses.domain.Store;
import com.helha.listecourses.infrastructure.store.DbStore;
import com.helha.listecourses.infrastructure.store.IStoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllStoreHandler implements IQueryHandler<GetAllStoreInput, GetAllStoreOutput> {

    @Autowired
    private IStoreRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public GetAllStoreOutput handle(GetAllStoreInput input) {

        GetAllStoreOutput output = new GetAllStoreOutput();

        Iterable<DbStore> dbStores = repository.findAll();

        for (DbStore dbStore : dbStores) {
            output.stores.add(mapper.map(dbStore, Store.class));
        }

        return output;
    }
}
