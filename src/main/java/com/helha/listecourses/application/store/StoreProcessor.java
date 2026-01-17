package com.helha.listecourses.application.store;


import com.helha.listecourses.application.store.query.getAll.GetAllStoreHandler;
import com.helha.listecourses.application.store.query.getAll.GetAllStoreInput;
import com.helha.listecourses.application.store.query.getAll.GetAllStoreOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreProcessor {

    @Autowired
    private GetAllStoreHandler getAllHandler;

    public GetAllStoreOutput getAll(GetAllStoreInput input) {
        return getAllHandler.handle(input);
    }
}
