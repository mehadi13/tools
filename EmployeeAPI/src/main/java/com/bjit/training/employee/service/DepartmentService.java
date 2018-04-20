package com.bjit.training.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjit.training.employee.model.Department;
import com.bjit.training.employee.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	public Department findOne(Integer id) {
		return departmentRepository.findOne(id);
	}
}
