package com.demo.loanapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.loanapp.entity.Repayment;

@Repository
public interface RepaymentRepository extends CrudRepository<Repayment, Integer> {

}
