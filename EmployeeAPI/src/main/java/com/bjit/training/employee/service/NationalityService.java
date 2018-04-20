package com.bjit.training.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjit.training.employee.model.Nationality;
import com.bjit.training.employee.repository.NationalityRepository;

@Service
public class NationalityService {

	@Autowired
	private NationalityRepository nationalityRepository;

	public List<Nationality> findAll() {
		return nationalityRepository.findAll();
	}

	public Nationality findOne(Integer id) {
		return nationalityRepository.findOne(id);
	}
}
