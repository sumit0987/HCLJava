package com.demo.flightBooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.flightBooking.Entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
