package com.example.demo;

import org.glassfish.jersey.internal.inject.Custom;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer findCustomerById(Integer id);
    Customer findCustomerByFirstName(String firstName);
}
