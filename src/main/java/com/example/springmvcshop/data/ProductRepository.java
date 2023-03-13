package com.example.springmvcshop.data;

import org.springframework.data.repository.CrudRepository;

import com.example.springmvcshop.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
