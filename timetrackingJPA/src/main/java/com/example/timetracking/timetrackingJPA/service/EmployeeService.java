package com.example.timetracking.timetrackingJPA.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.timetracking.timetrackingJPA.Utility.RecordNotFoundException;
import com.example.timetracking.timetrackingJPA.bean.Employee;
import com.example.timetracking.timetrackingJPA.bean.SwipeMovement;
import com.example.timetracking.timetrackingJPA.dto.EmployeeRoleDTO;

public interface EmployeeService {
	public Long saveEmployee(Employee emp);
	public Employee getEmployee(Long id) throws RecordNotFoundException;
	public int saveSwipe(SwipeMovement smv);
	public List<Employee> getAllEmployees() throws RecordNotFoundException;
	public List<EmployeeRoleDTO> getRolesCount() throws RecordNotFoundException;
}
