package com.demo.timetracking;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Timestamp swipeIn; 
	private Timestamp swipeOut; 
	private Date swipeDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getSwipeIn() {
		return swipeIn;
	}
	public void setSwipeIn(Timestamp swipeIn) {
		this.swipeIn = swipeIn;
	}
	public Timestamp getSwipeOut() {
		return swipeOut;
	}
	public void setSwipeOut(Timestamp swipeOut) {
		this.swipeOut = swipeOut;
	}
	public Date getSwipeDate() {
		return swipeDate;
	}
	public void setSwipeDate(Date swipeDate) {
		this.swipeDate = swipeDate;
	}

}
