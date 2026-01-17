package com.helha.listecourses.command.store;

import com.helha.listecourses.command.store.create.CreateStoreHandler;
import com.helha.listecourses.command.store.delete.DeleteStoreHandler;
import com.helha.listecourses.command.store.update.UpdateStoreHandler;
import com.helha.listecourses.command.store.update.UpdateStoreInput;
import com.helha.listecourses.infrastructure.store.DbStore;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreCommandProcessor {

    @Autowired
    public CreateStoreHandler createHandler;

    @Autowired
    public DeleteStoreHandler deleteHandler;

    public void  delete(Long id)
    {
        deleteHandler.handle(id);
    }

    @Autowired
    private UpdateStoreHandler updateHandler;

    public DbStore update(UpdateStoreInput input)
    {
        return updateHandler.handle(input);
    }


}
