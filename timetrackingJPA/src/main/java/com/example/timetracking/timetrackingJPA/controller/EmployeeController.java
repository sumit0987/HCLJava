package com.example.timetracking.timetrackingJPA.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.timetracking.timetrackingJPA.Utility.RecordNotFoundException;
import com.example.timetracking.timetrackingJPA.bean.Employee;
import com.example.timetracking.timetrackingJPA.bean.SwipeMovement;
import com.example.timetracking.timetrackingJPA.dto.EmployeeRoleDTO;
import com.example.timetracking.timetrackingJPA.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Long id=(long) 0;
		if(employee!=null) {
			id = empService.saveEmployee(employee);
		}
		 
	     if(id>0) {
	          return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	     }
	        throw new RuntimeException("EMPLOYEE ERROR");
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employeeList= empService.getAllEmployees();
		if(Objects.isNull(employeeList)||employeeList.size()==0) {
			throw new RecordNotFoundException("Employee list doesn't exist in controller");
		}
		return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
	}
	
	@GetMapping("/employees/count")
	  public ResponseEntity<List<EmployeeRoleDTO>> getEmployeeRoleCount(){
		  List<EmployeeRoleDTO> roleList = empService.getRolesCount();
		  if(Objects.isNull(roleList)||roleList.size()==0) {
				throw new RecordNotFoundException("Roles List not available");
			}
			return new ResponseEntity<List<EmployeeRoleDTO>>(roleList,HttpStatus.OK);
	}
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getEmployeeIdLocation(@Valid @PathVariable Long id){
			
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
