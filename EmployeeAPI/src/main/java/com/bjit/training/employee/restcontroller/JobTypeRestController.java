package com.bjit.training.employee.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjit.training.employee.model.ApiResponse;
import com.bjit.training.employee.model.ClassWrapper;
import com.bjit.training.employee.model.JobType;
import com.bjit.training.employee.service.JobTypeService;
import com.bjit.training.employee.util.ReturnCode;
import com.bjit.training.employee.util.ReturnStatus;

@RestController
@CrossOrigin
@RequestMapping("/v1/jobtypes")
public class JobTypeRestController {
	@Autowired
	private JobTypeService jobTypeService;

	@GetMapping
	public ApiResponse findAll() {
		List<JobType> jobtypes = jobTypeService.findAll();
		if (jobtypes != null) {
			return new ApiResponse(ClassWrapper.getWrapper("jobtypes", jobtypes)).send(ReturnStatus.SUCCESS,
					ReturnCode.SUCCESS, "Successful");
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "Job Type List not found!");
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOne(@PathVariable Integer id) {
		JobType jobType = jobTypeService.findOne(id);
		if (jobType != null) {
			return new ApiResponse(ClassWrapper.getWrapper("jobtype", jobType)).send(ReturnStatus.SUCCESS,
					ReturnCode.SUCCESS, "Successful");
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "JobType not found!");
		}
	}
}
