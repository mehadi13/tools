package com.bjit.training.employee.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjit.training.employee.model.ApiResponse;
import com.bjit.training.employee.model.ClassWrapper;
import com.bjit.training.employee.model.JobTitle;
import com.bjit.training.employee.service.JobTitleService;
import com.bjit.training.employee.util.ReturnCode;
import com.bjit.training.employee.util.ReturnStatus;

@RestController
@CrossOrigin
@RequestMapping("/v1/jobtitles")
public class JobTitleRestController {
	@Autowired
	private JobTitleService jobTitleService;

	@GetMapping
	public ApiResponse findAll() {
		List<JobTitle> jobtitles = jobTitleService.findAll();
		if (jobtitles != null) {
			return new ApiResponse(ClassWrapper.getWrapper("jobtitles", jobtitles)).send(ReturnStatus.SUCCESS,
					ReturnCode.SUCCESS, "Successful");
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "Job Title List not found!");
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOne(@PathVariable Integer id) {
		JobTitle jobTitle = jobTitleService.findOne(id);
		if (jobTitle != null) {
			return new ApiResponse(ClassWrapper.getWrapper("jobtitle", jobTitle)).send(ReturnStatus.SUCCESS,
					ReturnCode.SUCCESS, "Successful");
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "Job Title not found!");
		}
	}

	@PostMapping
	public void s(@RequestBody JobTitle jobTitle) {
		System.out.println(jobTitle.getName());
	}
}
