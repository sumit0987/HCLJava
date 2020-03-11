package com.example.timetracking.timetrackingJPA.dao;

import com.example.timetracking.timetrackingJPA.Utility.RecordNotFoundException;
import com.example.timetracking.timetrackingJPA.bean.Employee;
import com.example.timetracking.timetrackingJPA.bean.SwipeMovement;

public interface EmployeeDao {
	public int save(Employee emp);
	public Employee getEmp(int id) throws RecordNotFoundException;
	public int saveSwipeMovement(SwipeMovement smv);
}
