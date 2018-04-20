package com.bjit.training.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjit.training.employee.model.Nationality;

public interface NationalityRepository extends JpaRepository<Nationality, Integer> {

}
