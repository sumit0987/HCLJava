package com.demo.flightBooking.service;

import java.time.LocalDate;
import java.util.List;

import com.demo.flightBooking.Entity.Flight;


public interface FlightService {
	public int saveFlight(Flight flight);
	public List<Flight> getFlights(String source, String destination);
}
