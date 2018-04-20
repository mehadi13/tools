package com.bjit.training.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjit.training.employee.model.JobType;

public interface JobTypeRepository extends JpaRepository<JobType, Integer> {

}
