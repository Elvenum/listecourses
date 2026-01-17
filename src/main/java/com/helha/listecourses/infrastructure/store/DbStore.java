package com.helha.listecourses.infrastructure.store;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="store")
@Data
public class DbStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

}
