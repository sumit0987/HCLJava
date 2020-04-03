package com.demo.fundtransferapp.service;

import java.util.Date;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.fundtransferapp.dto.FundsTransferDto;
import com.demo.fundtransferapp.entity.AccountDetails;
import com.demo.fundtransferapp.entity.Customer;
import com.demo.fundtransferapp.entity.Transaction;
import com.demo.fundtransferapp.repository.AccountDetailsRepository;
import com.demo.fundtransferapp.repository.CustomerRepository;
import com.demo.fundtransferapp.repository.TransactionRepository;
import com.demo.fundtransferapp.utils.FundTransferUtility;

@Service
public class FundsTransferServiceImpl implements FundsTransferService {

	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	AccountDetailsRepository accountDetailsRepo;
	
	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	FundTransferUtility fundsUtil;
	
	@Override
	public String registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer cust= customerRepo.save(customer);
		if(Objects.isNull(cust)) {
			throw new RuntimeException("Customer not registered");
		}
		Long accountNumber=(long) 0;
		accountNumber=fundsUtil.generateRandom(12);
		if(Objects.isNull(accountNumber)) {
			throw new RuntimeException("Account Number not genearted, pls try again");
		}
		System.out.println("Account Number :"+accountNumber);
		AccountDetails accntDetails = new AccountDetails();
		accntDetails.setAccountNumber(accountNumber);
		accntDetails.setStatus("created");
		accntDetails.setCustomer(cust);
		accntDetails.setBalanceAmount(5000.00);
		AccountDetails acc = accountDetailsRepo.save(accntDetails);
		if(Objects.isNull(acc)) {
			throw new RuntimeException("Account not created, pls try again");
		}
		return String.valueOf(acc.getAccountNumber());
	}

	@Override
	@Transactional
	public String transferFunds(FundsTransferDto fundsTransferDto) {
		// TODO Auto-generated method stub
		int customerId=0;
		int payeeId=0;
		double amount=0.00;
		double accountBalance=0.00;
		if(Objects.isNull(fundsTransferDto)) {
			throw new RuntimeException("Bad request......");
		}
		customerId = fundsTransferDto.getCustomerId();
		amount = fundsTransferDto.getTransferAmount();
		payeeId=fundsTransferDto.getPayeeId();
		AccountDetails accDepositor = accountDetailsRepo.findAccountDetails(customerId);
		AccountDetails accCreditor = accountDetailsRepo.findAccountDetails(payeeId);
		if(Objects.isNull(accDepositor)||Objects.isNull(accCreditor)) {
			throw new RuntimeException("Error while fund transfer");
		}
		accountBalance = accDepositor.getBalanceAmount();
		if(accountBalance<amount || payeeId==customerId){
			throw new RuntimeException("Bad Request, Unsufficient funds/wrong payee");
		}
		double debitorCurrentBalance = accDepositor.getBalanceAmount(); 
		accountDetailsRepo.updateAccountDetails(accDepositor.getAccountNumber(),debitorCurrentBalance-amount);
		
		Transaction fundsTransaction = new Transaction();
		fundsTransaction.setTransactionDate(new Date());
		fundsTransaction.setAccountDetails(accDepositor);
		fundsTransaction.setTransactionAmount(amount);
		fundsTransaction.setTransactionType("debit");
		//transactionRepo.save(fundsTransaction);
		
		double creditorCurrentBalance = accCreditor.getBalanceAmount();
		accountDetailsRepo.updateAccountDetails(accCreditor.getAccountNumber(),creditorCurrentBalance+amount);
		
		Transaction fundsTransaction1 = new Transaction();
		fundsTransaction1.setTransactionDate(new Date());
		fundsTransaction1.setAccountDetails(accCreditor);
		fundsTransaction1.setTransactionAmount(amount);
		fundsTransaction1.setTransactionType("credit");
		//transactionRepo.save(fundsTransaction1);
		
		return "Funds transferred";
	}

}
