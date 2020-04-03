package com.demo.fundtransferapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.fundtransferapp.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}