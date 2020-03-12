package com.demo.flightBooking.service;

import java.util.List;

import com.demo.flightBooking.Entity.Passenger;
import com.demo.flightBooking.dto.BookingRequest;

public class BookingServiceImpl implements BookingService {

	@Override
	public void bookFlight(BookingRequest bookingRequest) {
		// TODO Auto-generated method stub
		int userId=0;
		int flightId=0;
		List<Passenger> passengerList=null;
		
		userId = bookingRequest.getUserId();
		flightId = bookingRequest.getFlightId();
		
		passengerList = bookingRequest.getPassengers();
		
		
	}

}
