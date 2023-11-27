package com.clientHandler.Repository;

import com.clientHandler.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
//    public Customer findByName(String name);
}
