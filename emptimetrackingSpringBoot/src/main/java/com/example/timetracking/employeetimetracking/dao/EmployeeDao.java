package com.example.timetracking.employeetimetracking.dao;

import com.example.timetracking.employeetimetracking.Utility.RecordNotFoundException;
import com.example.timetracking.employeetimetracking.bean.Employee;
import com.example.timetracking.employeetimetracking.bean.SwipeMovement;

public interface EmployeeDao {
	public int save(Employee emp);
	public Employee getEmp(int id) throws RecordNotFoundException;
	public int saveSwipeMovement(SwipeMovement smv);
}
