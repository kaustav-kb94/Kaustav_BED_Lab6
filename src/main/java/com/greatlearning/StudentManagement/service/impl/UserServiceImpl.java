package com.greatlearning.StudentManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.StudentManagement.entity.User;
import com.greatlearning.StudentManagement.repository.UserRepository;
import com.greatlearning.StudentManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);		
	}

}
