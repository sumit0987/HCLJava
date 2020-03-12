package com.demo.flightBooking.service;

import org.springframework.stereotype.Service;

import com.demo.flightBooking.Entity.User;


public interface UserService {
	public int saveUser(User user);
}
