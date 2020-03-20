package com.demo.loanapp.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "repayment")
public class Repayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int repaymentId;
	private double emiAmount;
	private Date repaymentDate;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",nullable = false)
	private Customer customer;

	public int getRepaymentId() {
		return repaymentId;
	}

	public void setRepaymentId(int repaymentId) {
		this.repaymentId = repaymentId;
	}

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public Date getRepaymentDate() {
		return repaymentDate;
	}

	public void setRepaymentDate(Date repaymentDate) {
		this.repaymentDate = repaymentDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Repayment() {
		
	}
}
