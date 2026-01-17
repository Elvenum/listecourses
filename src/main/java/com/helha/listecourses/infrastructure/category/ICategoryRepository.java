package com.helha.listecourses.infrastructure.category;

import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<DbCategory, Long> {
}