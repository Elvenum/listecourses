package com.helha.listecourses.application.shopping.toggle;

import com.helha.listecourses.command.ICommandHandler;
import com.helha.listecourses.infrastructure.shopping.DbShoppingItem;
import com.helha.listecourses.infrastructure.shopping.IShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToggleBoughtHandler implements ICommandHandler<ToggleBoughtInput, Void> {

    @Autowired
    private IShoppingRepository repository;

    @Override
    public Void handle(ToggleBoughtInput input) {
        // 1. On cherche l'élément dans la liste de courses
        DbShoppingItem item = repository.findById(input.getId())
                .orElseThrow(() -> new RuntimeException("Élément introuvable dans la liste"));

        // 2. On inverse le statut actuel (vrai -> faux / faux -> vrai)
        item.setBought(!item.isBought());

        // 3. On sauvegarde le changement
        repository.save(item);

        return null;
    }
}