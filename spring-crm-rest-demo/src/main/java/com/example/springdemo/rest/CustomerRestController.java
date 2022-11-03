package com.example.springdemo.rest;

import com.example.springdemo.entity.Customer;
import com.example.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    // add mapping for GET all /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    // add mapping for GET a /customers/{customerId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);

        if(customer == null)
            throw new CustomerNotFoundException("Customer id not found = " + customerId);

        return customer;
    }

    // add mapping for POST /customers  - add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@Valid @RequestBody Customer theCustomer, BindingResult result) {

        if(result.hasErrors())
            throw new RuntimeException("Enter valid record! Field cannot be empty or null");

        // also just in case the pass an id in JSON ... set id to 0
        // this is force a save of new item ... instead of update
        // if id is 0, then DAO will treat as INSERT
        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    // add mapping for PUT /customers - update existing customer
    @PutMapping("/customers")
    public Customer updateCustomer(@Valid @RequestBody Customer theCustomer, BindingResult result){
        if(result.hasErrors())
            throw new RuntimeException("Enter valid record! Field cannot be empty or null");

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if(customer == null)
            throw new CustomerNotFoundException("Customer not found : " + customerId);

        customerService.deleteCustomer(customerId);

        return "Deleted customer id = " + customerId;
    }
}
