package com.demo.loanapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.loanapp.dto.LoanDto;
import com.demo.loanapp.entity.Customer;
import com.demo.loanapp.entity.LoanDetails;
import com.demo.loanapp.entity.Repayment;
import com.demo.loanapp.service.LoanService;

@RestController
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	Job job;
	
//	@GetMapping("/load")
//	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
//		Map<String, JobParameter> parameters=new HashMap<>();
//		parameters.put("time", new JobParameter(System.currentTimeMillis()));
//		JobParameters jobParameters=new JobParameters(parameters);
//		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
//		System.out.println("JobExecution:  "+jobExecution.getStatus());
//		if(jobExecution.isRunning()) {
//			System.out.println("running-----------------");
//		}
//
//	return jobExecution.getStatus();
//	}
	
	@PostMapping("")
	public ResponseEntity<LoanDetails> applyLoan(@RequestBody LoanDto loanDto) {
			LoanDetails loanDetails = loanService.applyLoan(loanDto);
			if(Objects.isNull(loanDetails)) {
				throw new RuntimeException("Loan Not appluied");
			}
			return new ResponseEntity<LoanDetails>(loanDetails,HttpStatus.OK);
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<LoanDetails> getEmiDetails(@RequestBody LoanDto loanDto) {
			LoanDetails loanDetails = loanService.applyLoan(loanDto);
			if(Objects.isNull(loanDetails)) {
				throw new RuntimeException("Not appluied");
			}
			return new ResponseEntity<LoanDetails>(loanDetails,HttpStatus.OK);
		}
		 
	
	@PostMapping("/{id}/{emiAmount}")
	public ResponseEntity<Repayment> payEmi(@PathVariable int id,Double emiAmount) {
			Repayment repayment = loanService.payEmi(id, emiAmount);
			if(Objects.isNull(repayment)) {
				throw new RuntimeException("EMI payment failed");
			}
			return new ResponseEntity<Repayment>(repayment,HttpStatus.OK);
		}
	     
}
