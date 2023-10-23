package com.greatlearning.StudentManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.StudentManagement.entity.Role;
import com.greatlearning.StudentManagement.repository.RoleRepository;
import com.greatlearning.StudentManagement.service.RoleService;

@Service
public class RoleServiceImpl  implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);		
	}

}
