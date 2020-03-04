package com.demo.timetracking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String locationName;
	private String designation;
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public Timestamp getSwipeIn() { return swipeIn; } public void
	 * setSwipeIn(Timestamp swipeIn) { this.swipeIn = swipeIn; } public Timestamp
	 * getSwipeOut() { return swipeOut; } public void setSwipeOut(Timestamp
	 * swipeOut) { this.swipeOut = swipeOut; } public Date getSwipeDate() { return
	 * swipeDate; } public void setSwipeDate(Date swipeDate) { this.swipeDate =
	 * swipeDate; }
	 */
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
}
