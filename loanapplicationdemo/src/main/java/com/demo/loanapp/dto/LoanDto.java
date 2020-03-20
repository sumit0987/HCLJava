package com.demo.loanapp.dto;

public class LoanDto {
	private int tenureInMonths;
	private Double loanAmount;
	private int customerId;
	
	public LoanDto(int tenureInMonths, Double loanAmount, int customerId) {
		super();
		this.tenureInMonths = tenureInMonths;
		this.loanAmount = loanAmount;
		this.customerId = customerId;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public LoanDto() {
		
	}
	public int getTenureInMonths() {
		return tenureInMonths;
	}
	public void setTenureInMonths(int tenureInMonths) {
		this.tenureInMonths = tenureInMonths;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
}
