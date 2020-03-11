package com.example.timetracking.timetrackingJPA.bean;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "swipe_movement")
public class SwipeMovement {
	
	@Id
	@Column(name="movement_Id")
	private int movementId;
	@Column(name="swipe_Time")
	private Date swipeTime;
	@Column(name="swap_Flag")
	private String swapFlag;
	@Column(name="employee_Id")
	private BigInteger employeeId;
	
	public int getMovementId() {
		return movementId;
	}
	public void setMovementId(int movementId) {
		this.movementId = movementId;
	}
	public Date getSwipeTime() {
		return swipeTime;
	}
	public void setSwipeTime(Date swipeTime) {
		this.swipeTime = swipeTime;
	}
	public String getSwapFlag() {
		return swapFlag;
	}
	public void setSwapFlag(String swapFlag) {
		this.swapFlag = swapFlag;
	}
	public BigInteger getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(BigInteger employeeId) {
		this.employeeId = employeeId;
	}
}
