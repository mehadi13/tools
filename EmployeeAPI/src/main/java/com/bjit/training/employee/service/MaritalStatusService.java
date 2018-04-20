package com.bjit.training.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjit.training.employee.model.MaritalStatus;
import com.bjit.training.employee.repository.MaritalStatusRepository;

@Service
public class MaritalStatusService {

	@Autowired
	private MaritalStatusRepository maritalStatusRepository;

	public List<MaritalStatus> findAll() {
		return maritalStatusRepository.findAll();
	}

	public MaritalStatus findOne(Integer id) {
		return maritalStatusRepository.findOne(id);
	}
}
