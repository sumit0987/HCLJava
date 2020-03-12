package com.demo.flightBooking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.flightBooking.Entity.Flight;
import com.demo.flightBooking.dto.BookingRequest;

@RestController
public class BookingController {
	@PostMapping("/flights")
	public ResponseEntity<?> saveFlight(@RequestBody BookingRequest bookingRequest) {
		
	}	
}
