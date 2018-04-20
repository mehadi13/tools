package com.bjit.training.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjit.training.employee.model.MaritalStatus;

public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Integer> {

}
