package com.example.timetracking.employeetimetracking.service;

import org.springframework.http.ResponseEntity;

import com.example.timetracking.employeetimetracking.Utility.RecordNotFoundException;
import com.example.timetracking.employeetimetracking.bean.Employee;
import com.example.timetracking.employeetimetracking.bean.SwipeMovement;

public interface EmployeeService {
	public int saveEmployee(Employee emp);
	public Employee getEmployee(int id) throws RecordNotFoundException;
	public int saveSwipe(SwipeMovement smv);
}
