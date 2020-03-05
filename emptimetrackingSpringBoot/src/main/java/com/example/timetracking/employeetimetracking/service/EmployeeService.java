package com.example.timetracking.employeetimetracking.service;

import com.example.timetracking.employeetimetracking.bean.Employee;
import com.example.timetracking.employeetimetracking.bean.SwipeMovement;

public interface EmployeeService {
	public int saveEmployee(Employee emp);
	public Employee getEmployee();
	public int saveSwipe(SwipeMovement smv);
}
