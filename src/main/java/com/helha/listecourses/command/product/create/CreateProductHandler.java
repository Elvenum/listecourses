package com.helha.listecourses.command.product.create;

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
public class CreateProductHandler implements ICommandHandler<CreateProductInput, Product> {

    @Autowired
    private IProductRepository repository;

    @Autowired
    private ICategoryRepository categoryRepository; // Pour chercher la catégorie

    @Autowired
    private IStoreRepository storeRepository;       // Pour chercher le magasin

    @Autowired
    private ModelMapper mapper;

    @Override
    public Product handle(CreateProductInput input) {
        // 1. Transformation de base
        DbProduct dbProduct = mapper.map(input, DbProduct.class);

        // 2. On cherche la catégorie correspondante
        if (input.getCategoryId() != null) {
            DbCategory category = categoryRepository.findById(input.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Catégorie inexistante"));
            dbProduct.setCategory(category); // On fait le lien réel
        }

        // 3. On fait de même pour le magasin
        if (input.getStoreId() != null) {
            DbStore store = storeRepository.findById(input.getStoreId())
                    .orElseThrow(() -> new RuntimeException("Magasin inexistant"));
            dbProduct.setStore(store);
        }

        // 4. Sauvegarde finale
        dbProduct = repository.save(dbProduct);
        return mapper.map(dbProduct, Product.class);
    }
}
