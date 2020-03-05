package com.example.timetracking.employeetimetracking.dao;

import com.example.timetracking.employeetimetracking.bean.Employee;
import com.example.timetracking.employeetimetracking.bean.SwipeMovement;

public interface EmployeeDao {
	public int save(Employee emp);
	public void getEmp();
	public int saveSwipeMovement(SwipeMovement smv);
}
