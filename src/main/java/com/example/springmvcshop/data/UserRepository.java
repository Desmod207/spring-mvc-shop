package com.example.springmvcshop.data;

import org.springframework.data.repository.CrudRepository;

import com.example.springmvcshop.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
