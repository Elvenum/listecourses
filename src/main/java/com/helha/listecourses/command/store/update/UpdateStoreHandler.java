package com.helha.listecourses.command.store.update;


import com.helha.listecourses.infrastructure.category.ICategoryRepository;
import com.helha.listecourses.infrastructure.store.DbStore;
import com.helha.listecourses.infrastructure.store.IStoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateStoreHandler {


    @Autowired
    private IStoreRepository repository;

    @Autowired
    private ModelMapper mapper;

    public DbStore handle(UpdateStoreInput input ) {

        Optional<DbStore> existingStore = repository.findById(input.getId());

        if (existingStore.isPresent()) {
            DbStore storeToUpdate = existingStore.get();

            mapper.map(input, storeToUpdate);

            return repository.save(storeToUpdate);
        }

        return null;
    }
}
