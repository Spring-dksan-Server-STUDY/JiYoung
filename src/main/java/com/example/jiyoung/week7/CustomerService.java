package com.example.jiyoung.week7;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    Customer createCustomer(String name, int age, String email);

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(UUID customerId);

    Customer updateCustomer(String name, int age, String email);

    void deleteAllCustomers();
}