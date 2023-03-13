package com.example.springmvcshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.springmvcshop.Cart;
import com.example.springmvcshop.Product;
import com.example.springmvcshop.data.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

    private ProductRepository productRepository;

    public IndexController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ModelAttribute(name = "products")
    public Iterable<Product> showProducts() {
        Iterable<Product> products = productRepository.findAll();
        return products;
    }
    
    @GetMapping("/")
    public String index(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            session.setAttribute("cart", new Cart());
        }
        return "index";
    }

}
