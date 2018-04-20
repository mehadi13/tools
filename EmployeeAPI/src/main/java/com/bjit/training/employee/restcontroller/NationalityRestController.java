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
import com.bjit.training.employee.model.Nationality;
import com.bjit.training.employee.service.NationalityService;
import com.bjit.training.employee.util.ReturnCode;
import com.bjit.training.employee.util.ReturnStatus;

@RestController
@CrossOrigin
@RequestMapping("/v1/nationalities")
public class NationalityRestController {
	@Autowired
	private NationalityService nationalityService;

	@GetMapping
	public ApiResponse findAll() {
		List<Nationality> nationalities = nationalityService.findAll();
		if (nationalities != null) {
			return new ApiResponse(ClassWrapper.getWrapper("nationalities", nationalities)).send(ReturnStatus.SUCCESS,
					ReturnCode.SUCCESS, "Successful");
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "Nationality List not found!");
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOne(@PathVariable Integer id) {
		Nationality nationality = nationalityService.findOne(id);
		if (nationality != null) {
			return new ApiResponse(ClassWrapper.getWrapper("nationality", nationality))
					.send(ReturnStatus.NO_SEARCH_RESULT, ReturnCode.SUCCESS, "Successful");
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "Nationality not found!");
		}
	}
}
