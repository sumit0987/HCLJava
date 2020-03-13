package com.demo.flightBooking.dto;

public class BookingDTO {
	private String passengerName;
    private int passengerAge;
    private String passengerSex;
    private String passengerMealPreferences;
    
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getPassengerSex() {
		return passengerSex;
	}
	public void setPassengerSex(String passengerSex) {
		this.passengerSex = passengerSex;
	}
	public String getPassengerMealPreferences() {
		return passengerMealPreferences;
	}
	public void setPassengerMealPreferences(String passengerMealPreferences) {
		this.passengerMealPreferences = passengerMealPreferences;
	}
}
