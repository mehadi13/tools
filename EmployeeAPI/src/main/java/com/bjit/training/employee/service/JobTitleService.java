package com.bjit.training.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjit.training.employee.model.JobTitle;
import com.bjit.training.employee.repository.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;

	public List<JobTitle> findAll() {
		return jobTitleRepository.findAll();
	}

	public JobTitle findOne(Integer id) {
		return jobTitleRepository.findOne(id);
	}
}
