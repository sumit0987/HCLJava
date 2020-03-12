package com.demo.flightBooking.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.flightBooking.Entity.Flight;
import com.demo.flightBooking.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepo;
	@Override
	public int saveFlight(Flight flight) {
		// TODO Auto-generated method stub
		return flightRepo.save(flight).getFlightId();
	}
	@Override
	public List<Flight> getFlights(String source, String destination) {
		System.out.println("Source :"+source);
		System.out.println("Destination :"+destination);
		//System.out.println("Date :"+departuredateTime);
		return flightRepo.findAllBySourceAndDestination(source,destination);
	}

}
