package com.demo.loanapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.loanapp.dto.LoanDto;
import com.demo.loanapp.entity.Customer;
import com.demo.loanapp.entity.LoanDetails;
import com.demo.loanapp.entity.Repayment;
import com.demo.loanapp.repository.CustomerRepository;
import com.demo.loanapp.repository.LoanDetailsRepository;
import com.demo.loanapp.repository.RepaymentRepository;
import com.google.common.base.Optional;

@Service
public class LoanServiceImpl implements LoanService{
	
	@Autowired
	LoanDetailsRepository loanRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	RepaymentRepository repaymentRepo;

	@Override
	public LoanDetails applyLoan(LoanDto loanDto) {
		// TODO Auto-generated method stub
		int tenureInMonths = loanDto.getTenureInMonths();
		Double loanAmount = loanDto.getLoanAmount();
		float rateOfInterest = 5;
		LoanDetails loanDetails = new LoanDetails();
		loanDetails.setEmiAmount(calculateEmi(tenureInMonths, loanAmount, rateOfInterest));
		java.util.Optional<Customer> customer= customerRepo.findById(loanDto.getCustomerId());
		loanDetails.setCustomer(customer.get());
		loanDetails.setLoanAmount(loanAmount);
		loanDetails.setBalanceAmount(loanAmount);
		loanDetails.setTenure(tenureInMonths);
		return loanRepo.save(loanDetails);
		
	}
	
	public double calculateEmi(int months,Double amount, float interestRate) {
		double emi; 
	      
		interestRate = interestRate / (12 * 100); // one month interest 
        emi = (amount * interestRate * (float)Math.pow(1 + interestRate, months))  
                / (float)(Math.pow(1 + interestRate, months) - 1); 
        return emi;
	}

	@Override
	public Repayment payEmi(int id,Double emi) {
		// TODO Auto-generated method stub
		Repayment repayment = new Repayment();
		java.util.Optional<Customer> customer=customerRepo.findById(id);
		repayment.setCustomer(customer.get());
		repayment.setEmiAmount(emi);
		repayment.setRepaymentDate(new Date());
		return repaymentRepo.save(repayment);
		
		
	}

	@Override
	public void updateBalanceAmount() {
		// TODO Auto-generated method stub
		
	}
	
	

}
