package com.bjit.training.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjit.training.employee.model.Gender;
import com.bjit.training.employee.repository.GenderRepository;

@Service
public class GenderService {

	@Autowired
	private GenderRepository genderRepository;

	public List<Gender> findAll() {
		return genderRepository.findAll();
	}

	public Gender findOne(Integer id) {
		return genderRepository.findOne(id);
	}
}
