package com.helha.listecourses.controllers.shopping;

import com.helha.listecourses.application.shopping.query.getAll.GetAllShoppingHandler;
import com.helha.listecourses.application.shopping.query.getAll.GetAllShoppingInput;
import com.helha.listecourses.application.shopping.query.getAll.GetAllShoppingOutput;
import com.helha.listecourses.application.shopping.toggle.ToggleBoughtHandler;
import com.helha.listecourses.application.shopping.toggle.ToggleBoughtInput;
import com.helha.listecourses.command.shopping.CreateShoppingItemHandler;
import com.helha.listecourses.command.shopping.CreateShoppingItemInput;
import com.helha.listecourses.domain.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping")
public class ShoppingController {

    @Autowired
    private CreateShoppingItemHandler createHandler;

    @Autowired
    private ToggleBoughtHandler toggleHandler;

    @Autowired
    private GetAllShoppingHandler getAllHandler; // AJOUT ICI

    @GetMapping // AJOUT ICI
    public GetAllShoppingOutput getAll() {
        return getAllHandler.handle(new GetAllShoppingInput());
    }

    @PostMapping
    public void add(@RequestBody CreateShoppingItemInput input) {
        createHandler.handle(input);
    }

    @PatchMapping("/{id}/toggle")
    public void toggle(@PathVariable Long id) {
        ToggleBoughtInput input = new ToggleBoughtInput();
        input.setId(id);
        toggleHandler.handle(input);
    }
}