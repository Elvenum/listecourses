package com.helha.listecourses.infrastructure.store;

import com.helha.listecourses.infrastructure.product.DbProduct;
import org.springframework.data.repository.CrudRepository;

public interface IStoreRepository extends CrudRepository<DbStore, Long> {
}
