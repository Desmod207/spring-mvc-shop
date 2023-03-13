package com.example.springmvcshop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
