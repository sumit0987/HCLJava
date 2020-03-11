package com.example.timetracking.timetrackingJPA.dto;


public class EmployeeRoleDTO {
	private String role;
	private int count;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getCount() {
		return count;
	}
	public EmployeeRoleDTO(String role, int count) {
		super();
		this.role = role;
		this.count = count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
