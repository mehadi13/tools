package com.bjit.training.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bjit.training.employee.model.Employee;
import com.bjit.training.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Page<Employee> findAll(PageRequest request) {
		return employeeRepository.findAll(request);
	}

	public Employee findOne(Integer id) {
		return employeeRepository.findOne(id);
	}

	public Employee save(Employee e) {
		return employeeRepository.save(e);
	}
}
