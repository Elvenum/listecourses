package com.helha.listecourses.application.product.query.getAll;

import lombok.Data;

@Data
public class GetAllProductsInput {
    private Long storeId; // AJOUT : Si ce champ est rempli, on filtrera par magasin
    private Long categoryId;
}


//@Data
//public class GetAllProductsInput {
//    // On le laisse vide comme dans le projet Todo
//}