package com.helha.listecourses.application.product.query.getAll;

import com.helha.listecourses.domain.Product;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class GetAllProductsOutput {
    // C'est ici que l'on définit la "clé" qui apparaîtra dans le JSON (products)
    public List<Product> products = new ArrayList<>();
}