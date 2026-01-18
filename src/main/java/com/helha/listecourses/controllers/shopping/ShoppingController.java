package com.helha.listecourses.controllers.shopping;

import com.helha.listecourses.application.shopping.toggle.ToggleBoughtHandler;
import com.helha.listecourses.application.shopping.toggle.ToggleBoughtInput;
import com.helha.listecourses.command.shopping.CreateShoppingItemHandler;
import com.helha.listecourses.command.shopping.CreateShoppingItemInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //
@RequestMapping("/api/shopping")
public class ShoppingController {

    @Autowired
    private CreateShoppingItemHandler createHandler;

    @PostMapping //
    public void add(@RequestBody CreateShoppingItemInput input) {
        createHandler.handle(input);
    }

    @Autowired
    private ToggleBoughtHandler toggleHandler;

    @PatchMapping("/{id}/toggle") // On utilise Patch pour une petite modification
    public void toggle(@PathVariable Long id) {
        ToggleBoughtInput input = new ToggleBoughtInput();
        input.setId(id);
        toggleHandler.handle(input);
    }
}