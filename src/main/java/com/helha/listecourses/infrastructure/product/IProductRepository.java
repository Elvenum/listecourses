package com.helha.listecourses.infrastructure.product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepository extends CrudRepository<DbProduct, Long> {

    List<DbProduct> findByStoreId(Long storeId);
    List<DbProduct> findByCategoryId(Long categoryId);

    // AJOUT : Pour quand on veut les produits d'un magasin PRÉCIS dans une catégorie PRÉCISE
    List<DbProduct> findByStoreIdAndCategoryId(Long storeId, Long categoryId);

}






//public interface IProductRepository extends CrudRepository<DbProduct, Long> {
//    // Rien à écrire ici pour l'instant !
//}