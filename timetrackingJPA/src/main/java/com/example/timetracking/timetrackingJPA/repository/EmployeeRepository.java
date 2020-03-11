package com.example.timetracking.timetrackingJPA.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.timetracking.timetrackingJPA.bean.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	
	 @Query(value="select role as role, count(*) as count from employee group by role",nativeQuery = true)
	 public List<HashMap<String, String>> getEmployeeRoles();
}
