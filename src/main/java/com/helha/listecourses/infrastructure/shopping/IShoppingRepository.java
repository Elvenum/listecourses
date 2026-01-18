package com.helha.listecourses.infrastructure.shopping;

import org.springframework.data.repository.CrudRepository;

public interface IShoppingRepository extends CrudRepository<DbShoppingItem, Long> {
} //