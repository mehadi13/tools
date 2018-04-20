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
import com.bjit.training.employee.model.MaritalStatus;
import com.bjit.training.employee.service.MaritalStatusService;
import com.bjit.training.employee.util.ReturnCode;
import com.bjit.training.employee.util.ReturnStatus;

@RestController
@CrossOrigin
@RequestMapping("/v1/maritalstatuses")
public class MaritalStatusRestController {
	@Autowired
	private MaritalStatusService maritalStatusService;

	@GetMapping
	public ApiResponse findAll() {
		List<MaritalStatus> maritalstatus = maritalStatusService.findAll();
		if (maritalstatus != null) {
			return new ApiResponse(ClassWrapper.getWrapper("maritalstatuses", maritalstatus)).send(ReturnStatus.SUCCESS,
					ReturnCode.SUCCESS, "Successful");
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "Marital Status List not found!");
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOne(@PathVariable Integer id) {
		MaritalStatus maritalStatus = maritalStatusService.findOne(id);
		if (maritalStatus != null) {
			return new ApiResponse(ClassWrapper.getWrapper("maritalstatus", maritalStatus)).send(ReturnStatus.SUCCESS,
					ReturnCode.SUCCESS, "Successful");
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "Marital Status not found!");
		}
	}
}
