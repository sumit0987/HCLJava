package com.demo.fundtransferapp.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.fundtransferapp.dto.FundsTransferDto;
import com.demo.fundtransferapp.entity.AccountDetails;
import com.demo.fundtransferapp.entity.Customer;
import com.demo.fundtransferapp.service.FundsTransferService;

@RestController
@RequestMapping("/api/fundstransfer")
public class FundController {
	
	@Autowired
	FundsTransferService fundstransferService;
	
	
	@PostMapping("")
	public String transferFunds(@RequestBody FundsTransferDto fundsTransferDto) {
		return fundstransferService.transferFunds(fundsTransferDto);
	}
	
	@PostMapping("/register")
	public String openAccount(@RequestBody Customer customer) {
		String accountNumber=null;
		accountNumber = fundstransferService.registerCustomer(customer);
		if(Objects.isNull(accountNumber)) {
			throw new RuntimeException("Customer not registered");
		}
		return accountNumber;
	}
}
