package com.demo.loanapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LoanapplicationdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanapplicationdemoApplication.class, args);
	}

}
