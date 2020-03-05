package com.example.timetracking.employeetimetracking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.timetracking.employeetimetracking.bean.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	
    static final String INSERT_EMPLOYEE="insert into employeetimedb.employee(id,name,locationName,designation)values(?,?,?,?)";
    
	@Override
	public int save(Employee emp) {
		
		int rows = jdbcTemplate.update(INSERT_EMPLOYEE, emp.getId(),emp.getName(),emp.getLocationName(),emp.getDesignation());
	    return rows;
	    
		
	}

	@Override
	public void getEmp() {
		// TODO Auto-generated method stub
		
	}

}
