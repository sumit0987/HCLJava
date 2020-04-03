package com.demo.fundtransferapp.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.fundtransferapp.entity.AccountDetails;
import com.demo.fundtransferapp.entity.Customer;

@Repository
public interface AccountDetailsRepository extends CrudRepository<AccountDetails, Long> {
	
	@Modifying(clearAutomatically = true)
	@Query(value="UPDATE accountdetails SET balance_amount = ?2 where account_number=?1",nativeQuery = true)
    public int updateAccountDetails(long accountNumber, double balance);
	
	@Query(value="select * from accountdetails where userid=?",nativeQuery = true)
	public AccountDetails findAccountDetails(int customeerId);
	
}
