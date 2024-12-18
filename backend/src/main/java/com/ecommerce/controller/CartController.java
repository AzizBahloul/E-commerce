package com.ecommerce.controller;

import com.ecommerce.model.Cart;
import com.ecommerce.model.CartItem;
import com.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public Cart addToCart(@RequestBody CartItem item, Principal principal) {
        return cartService.addToCart(principal.getName(), item);
    }

    @DeleteMapping("/remove/{productId}")
    public Cart removeFromCart(@PathVariable String productId, Principal principal) {
        return cartService.removeFromCart(principal.getName(), productId);
    }

    @GetMapping
    public Cart getCart(Principal principal) {
        return cartService.getCart(principal.getName());
    }
}