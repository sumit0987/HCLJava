package com.demo.flightBooking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.flightBooking.entity.Address;
import com.demo.flightBooking.entity.User;


public interface UserService {
	public String saveUser(User user);
	public String saveAddress(Address address);
	public List<User> getAllUsers();
}
