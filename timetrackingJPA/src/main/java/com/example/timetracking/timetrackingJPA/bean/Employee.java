package com.example.timetracking.timetrackingJPA.bean;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	//@NotEmpty(message = "employee ID cannot be empty")
	private Long id;
	
	//@NotEmpty(message = "name cannot be empty")
	private String name;
	//@NotEmpty(message = "locationName cannot be empty")
	private String locationName;
	//@NotEmpty(message = "designation cannot be empty")
	private String designation;
	//@NotEmpty(message = "role cannot be empty")
	private String role;
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}