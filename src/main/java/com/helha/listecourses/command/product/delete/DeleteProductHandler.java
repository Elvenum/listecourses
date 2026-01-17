package com.helha.listecourses.command.product.delete;

import com.helha.listecourses.infrastructure.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Ajout de l'import

@Service // AJOUT : Pour que Spring reconnaisse cette classe
public class DeleteProductHandler {

    @Autowired
    private IProductRepository productRepository;

    // RENOMMAGE : On utilise "handle" pour rester fidèle au pattern
    public void handle(Long id) {
        productRepository.deleteById(id);
    }
}