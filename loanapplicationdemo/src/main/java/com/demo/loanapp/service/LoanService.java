package com.demo.loanapp.service;

import com.demo.loanapp.dto.LoanDto;
import com.demo.loanapp.entity.LoanDetails;
import com.demo.loanapp.entity.Repayment;

public interface LoanService {
	public LoanDetails applyLoan(LoanDto loanDto);
	public double calculateEmi(int months,Double amount, float interestRate);
	public Repayment payEmi(int id,Double emi);
	public void updateBalanceAmount();
}
