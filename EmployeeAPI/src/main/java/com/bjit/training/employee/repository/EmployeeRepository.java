package com.bjit.training.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjit.training.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
