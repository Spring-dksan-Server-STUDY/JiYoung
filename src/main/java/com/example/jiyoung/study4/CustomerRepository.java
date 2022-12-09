package com.example.jiyoung.study4;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Customer insert(Customer customer);

    Customer update(Customer customer);

    List<Customer> findAll();

    Optional<Customer> findById(UUID customerId);

    List<Customer> findByName(String name);

    Optional<Customer> findByEmail(String email);

    void deleteAll();
}