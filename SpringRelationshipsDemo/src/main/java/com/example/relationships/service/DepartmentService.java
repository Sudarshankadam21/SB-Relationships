package com.example.relationships.service;

import java.util.List;

import com.example.relationships.entity.Department;
import com.example.relationships.entity.User;

public interface DepartmentService {
	List<Department> getAllDepartments();

	Department getDepartmentById(Long id);

	List<User> addUser(List<User> user);
}
