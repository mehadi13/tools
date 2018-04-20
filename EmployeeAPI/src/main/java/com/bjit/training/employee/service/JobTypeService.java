package com.bjit.training.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjit.training.employee.model.JobType;
import com.bjit.training.employee.repository.JobTypeRepository;

@Service
public class JobTypeService {

	@Autowired
	private JobTypeRepository jobTypeRepository;

	public List<JobType> findAll() {
		return jobTypeRepository.findAll();
	}

	public JobType findOne(Integer id) {
		return jobTypeRepository.findOne(id);
	}
}
