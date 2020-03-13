package com.demo.flightBooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.flightBooking.Entity.Passenger;

public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

}
