package com.helha.listecourses.command.store.create;

import com.helha.listecourses.infrastructure.store.DbStore;
import com.helha.listecourses.infrastructure.store.IStoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateStoreHandler {

    @Autowired
    private IStoreRepository repository;

    @Autowired
    private ModelMapper mapper;

    public DbStore handle(CreateStoreInput input) {
        DbStore toSave = mapper.map(input, DbStore.class);

        return repository.save(toSave);
    }


}
