package com.demo.flightBooking.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.flightBooking.Entity.Booking;
import com.demo.flightBooking.Entity.Flight;
import com.demo.flightBooking.Entity.Passenger;
import com.demo.flightBooking.Entity.User;
import com.demo.flightBooking.dto.BookingDTO;
import com.demo.flightBooking.dto.BookingRequest;
import com.demo.flightBooking.repository.BookingRepository;
import com.demo.flightBooking.repository.FlightRepository;
import com.demo.flightBooking.repository.PassengerRepository;
import com.demo.flightBooking.repository.UserRepository;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	BookingRepository bookingRepo;
	@Autowired
	PassengerRepository passengerRepo;

	@Override
	public void bookFlight(BookingRequest bookingRequest) {
		// TODO Auto-generated method stub
		int userId=0;
		int flightId=0;
		List<BookingDTO> passengerList=null;
		
		userId = bookingRequest.getUserId();
		flightId = bookingRequest.getFlightId();
		passengerList = bookingRequest.getPassengers();
		
		Booking bookingData = new Booking();
		Optional<Flight> flight = flightRepo.findById(flightId);
		bookingData.setFlight(flight.get());
		Optional<User> user = userRepo.findById(userId);
		bookingData.setUser(user.get());
		bookingData.setBookingstatus("CNF");
		
		Booking booking = bookingRepo.save(bookingData);
		
		for (BookingDTO bookingDTO : passengerList) {
			Passenger passenger = new Passenger();
			passenger.setName(bookingDTO.getPassengerName());
			passenger.setAge(bookingDTO.getPassengerAge());
			passenger.setSex(bookingDTO.getPassengerSex());
			passenger.setMealPreference(bookingDTO.getPassengerMealPreferences());
			passenger.setBooking(booking);
			passengerRepo.save(passenger);
			
		}
	}

}
