package com.demo.flightBooking.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.flightBooking.Entity.Flight;
import com.demo.flightBooking.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@GetMapping("/search")
	public ResponseEntity<Flight> getFlightDetails(@PathVariable String source, String destination, Date departuredateTime){
		return null;
		
	}
	
	@GetMapping("/flights/{source}/{destination}")
	public ResponseEntity<List<Flight>> serachFlights(@PathVariable String source, String destination){
		List<Flight> flightList= flightService.getFlights(source, destination);
		if(Objects.isNull(flightList)||flightList.size()==0) {
			throw new com.demo.flightBooking.exceptionhandler.RecordNotFoundException("No Flights Found between "+source+" and "+destination);
		}
		return new ResponseEntity<List<Flight>>(flightList,HttpStatus.OK);
	}
	
	@PostMapping("/flights")
	public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight) {
		int id=0;
		if(flight!=null) {
			id = flightService.saveFlight(flight);
		}
		 
	     if(id>0) {
	          return new ResponseEntity<Flight>(flight, HttpStatus.OK);
	     }
	        throw new RuntimeException("Flight Save ERROR");
	}
}
