package com.helha.listecourses.command.product.delete;

import com.helha.listecourses.command.ICommandHandler;
import com.helha.listecourses.command.product.update.UpdateProductInput;
import com.helha.listecourses.domain.Product;
import com.helha.listecourses.infrastructure.product.DbProduct;
import com.helha.listecourses.infrastructure.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Ajout de l'import

@Service // Pour que Spring reconnaisse cette classe
public class DeleteProductHandler implements ICommandHandler<DeleteProductInput, Void> {
    // ^--- ON UTILISE DELETE ET VOID ICI

    @Autowired
    private IProductRepository repository; // On l'appelle simplement repository pour plus de facilité

    @Override
    public Void handle(DeleteProductInput input) {
        // 1. On vérifie s'il existe avant de supprimer
        DbProduct product = repository.findById(input.getId())
                .orElseThrow(() -> new RuntimeException("Suppression impossible : produit introuvable"));

        // 2. On supprime l'entité de la base
        repository.delete(product);

        // 3. On renvoie null car le type de retour est Void
        return null;
    }
}
