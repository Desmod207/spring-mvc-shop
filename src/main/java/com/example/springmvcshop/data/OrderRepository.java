package com.example.springmvcshop.data;

import org.springframework.data.repository.CrudRepository;

import com.example.springmvcshop.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
    
}
