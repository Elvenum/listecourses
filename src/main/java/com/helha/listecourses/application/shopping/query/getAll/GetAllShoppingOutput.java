package com.helha.listecourses.application.shopping.query.getAll;


import com.helha.listecourses.domain.ShoppingItem;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class GetAllShoppingOutput {
    public List<ShoppingItem> items = new ArrayList<>();
}