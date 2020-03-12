package com.demo.flightBooking.dto;

import java.util.List;

import com.demo.flightBooking.Entity.Passenger;

public class BookingRequest {
	
	private int userId;
	private int flightId;
	private List<Passenger> passengers;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	

}
