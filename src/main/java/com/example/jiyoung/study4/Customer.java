package com.example.jiyoung.study4;

import java.time.LocalDateTime;
import java.util.UUID;

public class Customer {
    private final UUID customerId;
    private String name;
    private int age;
    private final String email;
    private final LocalDateTime createdAt;

    public Customer(UUID customerId, String name, int age, String email, LocalDateTime createdAt) {
        validateName(name);
        this.customerId = customerId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.createdAt = createdAt;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new RuntimeException("이름에 빈칸이 포함되어있지 않아야 합니다.");
        }
    }

    public void changeName(String name) {
        validateName(name);
        this.name = name;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

