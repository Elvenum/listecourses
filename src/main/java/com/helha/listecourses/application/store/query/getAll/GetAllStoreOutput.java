package com.helha.listecourses.application.store.query.getAll;

import com.helha.listecourses.domain.Store;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetAllStoreOutput {
    public List<Store> stores = new ArrayList<>();
}
