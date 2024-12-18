package com.ecommerce.service;

import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    public List<Order> findOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public List<Order> findOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public double calculateTotal(Order order) {
        return order.getProductIds().stream()
                .mapToDouble(productId -> productRepository.findById(productId).get().getPrice())
                .sum();
    }
}
