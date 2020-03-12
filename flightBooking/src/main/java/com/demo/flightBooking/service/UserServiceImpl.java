package com.demo.flightBooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.flightBooking.Entity.User;
import com.demo.flightBooking.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user).getUserId();
	}

}
