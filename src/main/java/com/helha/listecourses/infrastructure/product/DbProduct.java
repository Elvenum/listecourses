package com.helha.listecourses.infrastructure.product;

import jakarta.persistence.*;
import lombok.Data;

    @Entity
    @Table(name="products")
    @Data
    public class DbProduct {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;
        private String name;
        private String category;
    }

