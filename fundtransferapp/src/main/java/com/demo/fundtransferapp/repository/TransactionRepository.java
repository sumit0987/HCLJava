package com.demo.fundtransferapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.fundtransferapp.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
