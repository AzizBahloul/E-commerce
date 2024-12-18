package com.ecommerce.service;

import com.ecommerce.model.Cart;
import com.ecommerce.model.CartItem;
import com.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(String username, CartItem item) {
        Cart cart = cartRepository.findByUserId(username);
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(username);
        }
        cart.getItems().add(item);
        cart.setTotalPrice(cart.getTotalPrice() + item.getPrice() * item.getQuantity());
        return cartRepository.save(cart);
    }

    public Cart removeFromCart(String username, String productId) {
        Cart cart = cartRepository.findByUserId(username);
        if (cart != null) {
            cart.getItems().removeIf(item -> item.getProductId().equals(productId));
            cart.setTotalPrice(cart.getItems().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum());
            return cartRepository.save(cart);
        }
        return null;
    }

    public Cart getCart(String username) {
        return cartRepository.findByUserId(username);
    }
}