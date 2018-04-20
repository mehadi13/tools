package com.bjit.training.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjit.training.employee.model.JobTitle;

public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {

}
