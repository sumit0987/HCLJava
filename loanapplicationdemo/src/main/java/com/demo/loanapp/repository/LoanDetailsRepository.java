package com.demo.loanapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.loanapp.entity.LoanDetails;

@Repository
public interface LoanDetailsRepository extends CrudRepository<LoanDetails, Integer> {

}
