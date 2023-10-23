package com.greatlearning.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.StudentManagement.entity.Role;
import com.greatlearning.StudentManagement.entity.User;
import com.greatlearning.StudentManagement.service.RoleService;
import com.greatlearning.StudentManagement.service.UserService;



@RestController
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@PostMapping("/addUser")
	public User addUserDetails(@RequestBody User user) {	
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		User addedUser = userService.saveUser(user);
		return addedUser;
		
	}

	@PostMapping("/addRole")
	public Role addRoleDetails(@RequestBody Role role) {
		Role addedRole = roleService.saveRole(role);
		return addedRole;
		
	}
}
