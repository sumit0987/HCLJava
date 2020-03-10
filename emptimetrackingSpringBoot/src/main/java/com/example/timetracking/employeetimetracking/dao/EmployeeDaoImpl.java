package com.example.timetracking.employeetimetracking.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.timetracking.employeetimetracking.Utility.RecordNotFoundException;
import com.example.timetracking.employeetimetracking.bean.Employee;
import com.example.timetracking.employeetimetracking.bean.SwipeMovement;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	
    static final String INSERT_EMP="insert into employeetimedb.employee(id,name,locationName,designation,role)values(?,?,?,?,?)";
    static final String INSERT_SWIPE="insert into employeetimedb.swipe_movement(movementId,swipeTime,swapFlag,employeeId)values(?,?,?,?)";
    
	@Override
	public int save(Employee emp) {
		
		int rows = jdbcTemplate.update(INSERT_EMP, emp.getId(),emp.getName(),emp.getLocationName(),emp.getDesignation(),emp.getRole());
	    return rows;
	    
		
	}


	public Employee getEmp(int id) throws RecordNotFoundException{
		Employee employee;
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		try {
			 employee = jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?",rowMapper, id);
			
		}catch(Exception e) {
			throw new RecordNotFoundException("Record not found for employee Id :"+id);
		}
		return employee;
		
	}

	@Override
	public int saveSwipeMovement(SwipeMovement smv) {
		// TODO Auto-generated method stub
		int rows = jdbcTemplate.update(INSERT_SWIPE, smv.getMovementId(),new Date(),smv.getSwapFlag(),smv.getEmployeeId());
	    return rows;
	}

}
