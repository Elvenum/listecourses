package com.helha.listecourses.controllers.store;

import com.helha.listecourses.command.store.StoreCommandProcessor;
import com.helha.listecourses.command.store.create.CreateStoreInput;
import com.helha.listecourses.command.store.update.UpdateStoreInput;
import com.helha.listecourses.infrastructure.store.DbStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class StoreCommandController {

    @Autowired
    private StoreCommandProcessor processor;

    @PostMapping
    public DbStore create(@RequestBody CreateStoreInput input) {
        return processor.createHandler.handle(input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
         processor.delete(id);
    }

    @PutMapping
    public DbStore update(@RequestBody UpdateStoreInput input) {
        return processor.update(input);
    }
}
