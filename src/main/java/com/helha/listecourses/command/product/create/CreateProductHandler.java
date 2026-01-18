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
        // 1. On crée l'objet DbProduct manuellement ou on vide les IDs pour le mapper
        DbProduct dbProduct = new DbProduct();
        dbProduct.setName(input.getName());
        // Si tu as d'autres champs simples (prix, quantité), ajoute-les ici :
        // dbProduct.setPrice(input.getPrice());

        // 2. On cherche la catégorie correspondante (TON CODE ÉTAIT BON ICI)
        if (input.getCategoryId() != null) {
            DbCategory category = categoryRepository.findById(input.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Catégorie inexistante"));
            dbProduct.setCategory(category);
        }

        // 3. On fait de même pour le magasin
        if (input.getStoreId() != null) {
            DbStore store = storeRepository.findById(input.getStoreId())
                    .orElseThrow(() -> new RuntimeException("Magasin inexistant"));
            dbProduct.setStore(store);
        }

        // 4. Sauvegarde et conversion finale
        dbProduct = repository.save(dbProduct);
        return mapper.map(dbProduct, Product.class); // Ici le mapper ne risque rien
    }
}
