package com.example.backend.lambda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.lambda.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
