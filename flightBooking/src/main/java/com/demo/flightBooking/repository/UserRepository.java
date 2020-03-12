package com.demo.flightBooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.flightBooking.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
