package com.example.springmvcshop.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springmvcshop.Cart;
import com.example.springmvcshop.Order;
import com.example.springmvcshop.User;
import com.example.springmvcshop.data.OrderRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

    private OrderRepository orderRepository;

    public CartController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/cart")
    public String showCart(HttpSession session, Model model) {
        Cart cart = (Cart)session.getAttribute("cart");
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/cart")
    public String order(HttpSession session, @AuthenticationPrincipal User user) {
        // Тут мы должны проверить прошла ли транзакция и если да вносим заказ в БД и дальше 
        // например связвться с брокером сообщений
        Order order = new Order();
        order.setUserId(user.getId());
        order.setDeliveryName(user.getFullname());
        order.setDeliveryAddress(user.getDeliveryAddress());
        Cart cart = (Cart)session.getAttribute("cart");
        order.addAllProducts(cart.getProducts());
        orderRepository.save(order);
        System.out.println("Your order has been successfully accepted\n" + order.getProducts().toString() + "\n");

        session.setAttribute("cart", new Cart()); // Очищаем корзину после оформления заказа
        return "/orderSeccess";
    }
    
}
