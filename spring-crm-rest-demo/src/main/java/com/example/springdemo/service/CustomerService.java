package com.example.springdemo.service;

import com.example.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
