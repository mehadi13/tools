package com.bjit.training.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjit.training.employee.model.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer> {

}
