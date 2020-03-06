package com.example.timetracking.employeetimetracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.timetracking.employeetimetracking.bean.Employee;
import com.example.timetracking.employeetimetracking.bean.SwipeMovement;
import com.example.timetracking.employeetimetracking.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;
	
	@Override
	public int saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.save(emp);
	}

	@Override
	public Employee getEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int saveSwipe(SwipeMovement smv) {
		// TODO Auto-generated method stub
		return empDao.saveSwipeMovement(smv);
	}

}
