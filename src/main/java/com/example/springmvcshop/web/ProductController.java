package com.example.springmvcshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springmvcshop.Cart;
import com.example.springmvcshop.Product;
import com.example.springmvcshop.data.ProductRepository;
import com.example.springmvcshop.data.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/products")
public class ProductController {

    ProductRepository productRepository;

    UserRepository userRepository;

    public ProductController(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }
    
    @GetMapping
    public String products() {
        return "redirect:/";
    } 

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productRepository.findById(id).orElse(null));
        return "products/product";
    }

    @PostMapping("/{id}")
    public String addProductToCart(@PathVariable("id") Long id, HttpSession session) {
        Product product = productRepository.findById(id).get();
        Cart cart = (Cart)session.getAttribute("cart");
        cart.addProduct(product);
        session.setAttribute("cart", cart);
        
        return "redirect:/";
    }

}
