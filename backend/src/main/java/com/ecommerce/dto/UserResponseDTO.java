package com.ecommerce.dto;

import java.time.LocalDateTime;

public class UserResponseDTO {
    private String id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private String role;

    // Default Constructor
    public UserResponseDTO() {
    }

    // Parameterized Constructor
    public UserResponseDTO(String id, String username, String email, LocalDateTime createdAt, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.role = role;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // toString Method
    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", role='" + role + '\'' +
                '}';
    }
}
