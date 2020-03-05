package com.example.timetracking.employeetimetracking.bean;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private BigInteger id;
	private String name;
	private String locationName;
	private String designation;
	
	
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
}