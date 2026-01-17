package com.helha.listecourses.controllers.store;


import com.helha.listecourses.application.store.StoreProcessor;
import com.helha.listecourses.application.store.query.getAll.GetAllStoreInput;
import com.helha.listecourses.application.store.query.getAll.GetAllStoreOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreProcessor processor;

    @GetMapping
    public GetAllStoreOutput getAll() {
        return processor.getAll(new GetAllStoreInput());
    }


}
