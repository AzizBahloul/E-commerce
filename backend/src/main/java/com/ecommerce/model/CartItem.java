package com.ecommerce.model;

public class CartItem {
    private String productId;
    private int quantity;
    private double price;

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to calculate the total price for this item (quantity * price)
    public double getTotalPrice() {
        return quantity * price;
    }
}
