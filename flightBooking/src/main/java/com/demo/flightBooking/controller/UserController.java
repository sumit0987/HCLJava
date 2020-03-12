package com.demo.flightBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.flightBooking.Entity.User;
import com.demo.flightBooking.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		int id=0;
		if(user!=null) {
			id = userService.saveUser(user);
		}
		 
	     if(id>0) {
	          return new ResponseEntity<User>(user, HttpStatus.OK);
	     }
	        throw new RuntimeException("User Save Error");
	}
}
