package com.clientHandler.Service;

import com.clientHandler.Entity.Customer;
import com.clientHandler.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public Customer saveCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    public Customer checkCustomer(String names ){
       List<Customer> list = this.customerRepository.findAll();
       List<Customer> cs = list.stream().filter(e -> e.getCustomerName().startsWith(names)).collect(Collectors.toList());

       if(cs.size() == 0){
           return null;
       }
       else {
           Customer c = cs.get(0);
           return c;
       }

    }
    public void  deleteCustomer(String name ){
        List<Customer> customers = this.customerRepository.findAll();
        List<Customer> list = customers.stream().filter(e -> e.getCustomerName().startsWith(name)).collect(Collectors.toList());
        Customer customer = list.get(0);
        this.customerRepository.delete(customer);
    }
}
