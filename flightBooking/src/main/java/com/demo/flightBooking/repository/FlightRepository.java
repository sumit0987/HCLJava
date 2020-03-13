package com.demo.flightBooking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.flightBooking.Entity.Flight;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer> {
	public List<Flight> findAllBySourceAndDestination(String source, String destination);

}
