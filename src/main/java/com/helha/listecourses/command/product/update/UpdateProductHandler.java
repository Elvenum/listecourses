package com.helha.listecourses.command.product.update;

import com.helha.listecourses.command.ICommandHandler;
import com.helha.listecourses.domain.Product;
import com.helha.listecourses.infrastructure.category.DbCategory;
import com.helha.listecourses.infrastructure.category.ICategoryRepository;
import com.helha.listecourses.infrastructure.product.DbProduct;
import com.helha.listecourses.infrastructure.product.IProductRepository;
import com.helha.listecourses.infrastructure.store.DbStore;
import com.helha.listecourses.infrastructure.store.IStoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UpdateProductHandler implements ICommandHandler<UpdateProductInput, Product> {

    @Autowired
    private IProductRepository repository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private IStoreRepository storeRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Product handle(UpdateProductInput input) {
        // 1. On récupère le produit existant
        DbProduct dbProduct = repository.findById(input.getId())
                .orElseThrow(() -> new RuntimeException("Produit introuvable"));

        // 2. On met à jour le nom
        dbProduct.setName(input.getName());

        // 3. On met à jour la catégorie si besoin
        if (input.getCategoryId() != null) {
            DbCategory category = categoryRepository.findById(input.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Catégorie introuvable"));
            dbProduct.setCategory(category);
        }

        // 4. On met à jour le magasin si besoin
        if (input.getStoreId() != null) {
            DbStore store = storeRepository.findById(input.getStoreId())
                    .orElseThrow(() -> new RuntimeException("Magasin introuvable"));
            dbProduct.setStore(store);
        }

        // 5. On enregistre les modifications
        dbProduct = repository.save(dbProduct);
        return mapper.map(dbProduct, Product.class);
    }
}
//@Service
//public class UpdateProductHandler {
//
//    @Autowired
//    private IProductRepository repository;
//
//    @Autowired
//    private ModelMapper mapper;
//
//    public DbProduct handle(UpdateProductInput input) {
//        // 1. On cherche le produit existant dans Docker
//        Optional<DbProduct> existingProduct = repository.findById(input.getId());
//
//        if (existingProduct.isPresent()) {
//            DbProduct productToUpdate = existingProduct.get();
//
//            // 2. On "écrase" les anciennes valeurs par les nouvelles
//            // ModelMapper va copier le nom et la catégorie de l'input vers le produit
//            mapper.map(input, productToUpdate);
//
//            // 3. On sauvegarde le produit mis à jour
//            return repository.save(productToUpdate);
//        }
//
//        // Si le produit n'existe pas, on pourrait renvoyer null ou une erreur
//        return null;
//    }
//}