package com.example.relationships.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.relationships.entity.Department;
import com.example.relationships.entity.User;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	List<User> save(List<User> user);
}
