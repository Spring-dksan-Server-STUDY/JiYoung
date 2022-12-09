package com.example.jiyoung.week7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //rest api를 위한
public class CustomerController {
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping ("/api/v0/customers")
    public Customer createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest){
        return customerService.createCustomer(createCustomerRequest.name(),createCustomerRequest.age(),
                createCustomerRequest.email());
    }

    @GetMapping("/api/v0/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
