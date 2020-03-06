package com.example.timetracking.employeetimetracking.bean;

import java.math.BigInteger;
import java.sql.Date;

public class SwipeMovement {
	private int movementId;
	private Date swipeTime;
	private String swapFlag;
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
