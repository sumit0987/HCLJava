package com.example.timetracking.employeetimetracking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.timetracking.employeetimetracking.Utility.RecordNotFoundException;
import com.example.timetracking.employeetimetracking.bean.Employee;
import com.example.timetracking.employeetimetracking.bean.SwipeMovement;
import com.example.timetracking.employeetimetracking.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		int rows=0;
		if(employee!=null) {
			rows = empService.saveEmployee(employee);
		}
		 
	     if(rows>0) {
	          return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	     }
	        throw new RuntimeException("EMPLOYEE ERROR");
	}
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployeeIdLocation(@PathVariable int id){
			
		Employee emp = empService.getEmployee(id);
		if(emp!=null) {
	        return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	    } else {
	        throw new RecordNotFoundException("Record not found for employee Id :"+id);
	      }
		 
		 
	}
	
	@PostMapping("/employees/swipe")
	public ResponseEntity<SwipeMovement> recordSwipeMovement(@RequestBody SwipeMovement swipeMv) {
		int rows = empService.saveSwipe(swipeMv);
		if(rows>0) {
	          return new ResponseEntity<SwipeMovement>(swipeMv, HttpStatus.OK);
	     }
	        throw new RuntimeException("SWIPE ERROR");
	}
}
