package com.example.relationships.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.relationships.dao.DepartmentRepository;
import com.example.relationships.entity.Department;
import com.example.relationships.entity.User;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<User> addUser(List<User> user) {

		List<User> saveUser = departmentRepository.save(user);

		return saveUser;
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(Long id) {
		return departmentRepository.findById(id).orElse(null);
	}

}
