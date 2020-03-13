package com.demo.flightBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.flightBooking.Entity.Flight;
import com.demo.flightBooking.dto.BookingRequest;
import com.demo.flightBooking.service.BookingService;
import com.demo.flightBooking.vo.BookingHistoryVO;

@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/booking")
	public String bookFlight(@RequestBody BookingRequest bookingRequest) {
		bookingService.bookFlight(bookingRequest);
		return "Flight booked successfully";
	}
	
	@PostMapping("/booking/history")
	public ResponseEntity<BookingHistoryVO> getBookingHistory(){
		
		return null;
	}
}
