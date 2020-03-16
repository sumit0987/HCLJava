package com.demo.flightBooking.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.flightBooking.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	
	public String saveUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().persist(user);
		return "user added successfully";
	}
	
	public List<User> getAllUsers(){
		return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
	}

}
