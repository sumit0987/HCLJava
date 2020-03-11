package com.example.timetracking.timetrackingJPA.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.timetracking.timetrackingJPA.Utility.RecordNotFoundException;
import com.example.timetracking.timetrackingJPA.bean.Employee;
import com.example.timetracking.timetrackingJPA.bean.SwipeMovement;
import com.example.timetracking.timetrackingJPA.dao.EmployeeDao;
import com.example.timetracking.timetrackingJPA.dto.EmployeeRoleDTO;
import com.example.timetracking.timetrackingJPA.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public Long saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp).getId();
	}

	@Override
	public Employee getEmployee(Long id) throws RecordNotFoundException{
		//return empDao.getEmp(id);
		Optional<Employee> emp = empRepo.findById((long) id);
		if(!emp.isPresent()) {
			throw new RecordNotFoundException("Record Not found for employee : "+id);
		}
		return emp.get();
	}
	
	@Override
	public int saveSwipe(SwipeMovement smv) {
		// TODO Auto-generated method stub
		return empDao.saveSwipeMovement(smv);
	}

	@Override
	public List<Employee> getAllEmployees() throws RecordNotFoundException{
		// TODO Auto-generated method stub
		List<Employee> employees = (List<Employee>) empRepo.findAll();
		if(Objects.isNull(employees)||employees.size()==0){
			throw new RecordNotFoundException("Employee list doesn't exist");
		}
		return employees;
	}

	@Override
	public List<EmployeeRoleDTO> getRolesCount() throws RecordNotFoundException{
		// TODO Auto-generated method stub
		List<HashMap<String, String>> roles = empRepo.getEmployeeRoles();
		List<EmployeeRoleDTO> roleList=new ArrayList<>();
		
		roles.forEach(empRole->{
			//Integer integer = empRole.get("role");
			EmployeeRoleDTO empDTO = new EmployeeRoleDTO((String)empRole.get("role"), Integer.parseInt((empRole.get("count"))));
			roleList.add(empDTO);
			
		});
		
		return roleList;
		
	}
	
	

}
