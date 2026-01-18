package com.helha.listecourses.infrastructure.shopping;

import com.helha.listecourses.infrastructure.product.DbProduct;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "shopping_list")
@Data
public class DbShoppingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DbProduct product; // Lien vers le produit

    private Double quantity;
    private boolean isBought = false; // Par défaut, non acheté
}