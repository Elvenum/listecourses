package com.helha.listecourses.infrastructure.product;

import com.helha.listecourses.infrastructure.category.DbCategory;
import com.helha.listecourses.infrastructure.store.DbStore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
    @Table(name="products")
    @NoArgsConstructor
    @Data
    public class DbProduct {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;
        private String name;

        @ManyToOne // Indique qu'un produit appartient à une seule catégorie
        @JoinColumn(name = "categoryId") // Crée la colonne de lien dans la DB
        private DbCategory category;

        @ManyToOne // Pareil pour le magasin
        @JoinColumn(name = "storeId")
        private DbStore store;
    }

