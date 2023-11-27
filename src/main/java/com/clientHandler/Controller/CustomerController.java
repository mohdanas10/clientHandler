package com.clientHandler.Controller;

import com.clientHandler.Entity.Customer;
import com.clientHandler.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public Customer saveCustomer (@RequestBody Customer customer){
        return this.customerService.saveCustomer(customer);
    }

    @GetMapping("/checkCustomer/{names}")
    public Customer checkCustomer(@PathVariable("names") String names ){
       return this.customerService.checkCustomer(names);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteCustomer(@PathVariable("name") String name ){
        this.customerService.deleteCustomer(name);
    }


}
