package com.demo.loanapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.loanapp.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
