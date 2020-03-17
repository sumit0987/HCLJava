package com.demo.flightBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.flightBooking.entity.Address;
import com.demo.flightBooking.entity.User;
import com.demo.flightBooking.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	@PostMapping("/users")
	public String saveUser(@RequestBody User user) {
			return userService.saveUser(user);
		 
	}
	@GetMapping("/users")
	public List<User> getUsers() {
			return userService.getAllUsers();
		 
	}
	
	@PostMapping("/address")
	public String saveAddress(@RequestBody Address address) {
			return userService.saveAddress(address);
		 
	}
}
