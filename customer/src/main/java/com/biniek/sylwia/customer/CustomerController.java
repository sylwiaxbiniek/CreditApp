package com.biniek.sylwia.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PostMapping("/getCustomers")
    public List<Customer> getCustomers(@RequestBody List<Long> credits) {
        return customerService.getAllByIds(credits);
    }

}
