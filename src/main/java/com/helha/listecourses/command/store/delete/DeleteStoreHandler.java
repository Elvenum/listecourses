package com.helha.listecourses.command.store.delete;

import com.helha.listecourses.infrastructure.store.IStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStoreHandler {

    @Autowired
    public IStoreRepository repository;

    public void handle(Long id)
    {
        repository.deleteById(id);
    }

}
