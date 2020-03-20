package com.demo.loanapp.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.demo.loanapp.entity.Customer;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer>{

	@Override
	public Customer process(Customer item) throws Exception {
		// TODO Auto-generated method stub
		int userid = item.getUserid();
	    String name = item.getName();
	    String gender = item.getGender();
	    int age = item.getAge();
	    String panno = item.getPanno();
	    Long aadharno = item.getAadharno();
	    Double salary = item.getSalary();

	    Customer customer = new Customer(userid, name, gender, age, panno, aadharno, salary);
	    
	    return customer;

	}

}
