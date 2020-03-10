package com.example.timetracking.employeetimetracking.bean;

import java.math.BigInteger;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@NotEmpty(message = "employee ID cannot be empty")
	private BigInteger id;
	
	@NotEmpty(message = "name cannot be empty")
	private String name;
	@NotEmpty(message = "locationName cannot be empty")
	private String locationName;
	@NotEmpty(message = "designation cannot be empty")
	private String designation;
	@NotEmpty(message = "role cannot be empty")
	private String role;
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
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