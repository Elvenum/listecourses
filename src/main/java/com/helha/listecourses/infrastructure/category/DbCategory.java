package com.helha.listecourses.infrastructure.category; // Vérifie bien le nom du dossier

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="categories") // N'oublie pas le @ ici
@Data
public class DbCategory { // Une seule classe simple, pas de "static class" à l'intérieur

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}