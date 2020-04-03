package com.demo.fundtransferapp.service;

import com.demo.fundtransferapp.dto.FundsTransferDto;
import com.demo.fundtransferapp.entity.AccountDetails;
import com.demo.fundtransferapp.entity.Customer;

public interface FundsTransferService {
	public String registerCustomer(Customer customer);
	public String transferFunds(FundsTransferDto fundsTransferDto);
}
