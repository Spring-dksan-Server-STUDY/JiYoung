package com.example.jiyoung.week7;

import java.time.LocalDateTime;
import java.util.UUID;

public class Customer {
    private final UUID customerId;
    private String name;
    private int age;
    private final String email;
    private final LocalDateTime createAt;

    public Customer(UUID customerId, String name, int age, String email, LocalDateTime createAt) {
        this.customerId = customerId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.createAt = createAt;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }
}