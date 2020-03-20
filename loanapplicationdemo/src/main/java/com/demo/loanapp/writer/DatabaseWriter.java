package com.demo.loanapp.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.loanapp.entity.Customer;
import com.demo.loanapp.repository.CustomerRepository;

@Component
public class DatabaseWriter implements ItemWriter<Customer>{

	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public void write(List<? extends Customer> items) throws Exception {
		// TODO Auto-generated method stub
		items.forEach(System.out::println);
		
		customerRepo.saveAll(items);
	}
	
}
