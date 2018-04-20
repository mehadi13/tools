package com.bjit.training.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjit.training.employee.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
