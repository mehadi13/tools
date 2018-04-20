package com.bjit.training.employee.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bjit.training.employee.model.ApiResponse;
import com.bjit.training.employee.model.ClassWrapper;
import com.bjit.training.employee.model.Employee;
import com.bjit.training.employee.model.PageInfo;
import com.bjit.training.employee.service.EmployeeService;
import com.bjit.training.employee.util.ReturnCode;
import com.bjit.training.employee.util.ReturnStatus;

@RestController
@CrossOrigin
@RequestMapping("/v1/employees")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ApiResponse findAll(@RequestParam(name = "page", defaultValue = "${page.number}") int page,
			@RequestParam(name = "size", defaultValue = "${page.size}") int size) {

		PageRequest request = new PageRequest(page - 1, size);
		Page<Employee> pages = employeeService.findAll(request);

		if (pages != null) {
			List<Employee> employees = new ArrayList<>();
			for (Employee employee : pages) {
				employees.add(employee);
			}
			PageInfo pageInfo = new PageInfo(pages.getNumber(), pages.getSize(), pages.getNumberOfElements(),
					pages.getTotalElements(), pages.getTotalPages());
			return new ApiResponse(ClassWrapper.getWrapper("employees", employees)).send(ReturnStatus.SUCCESS,
					ReturnCode.SUCCESS, "Successful", pageInfo);
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "Employee List not found!");
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOne(@PathVariable Integer id) {
		Employee employee = employeeService.findOne(id);
		if (employee != null) {
			return new ApiResponse(ClassWrapper.getWrapper("employee", employee)).send(ReturnStatus.SUCCESS,
					ReturnCode.SUCCESS, "Successful");
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "Employee not found!");
		}
	}

	@PostMapping
	public ApiResponse save(@Valid @RequestBody Employee e, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return validationErrorResponse(bindingResult);
		}

		Employee employee = employeeService.save(e);
		if (employee != null) {
			return new ApiResponse(ClassWrapper.getWrapper("employee", employee)).send(ReturnStatus.SUCCESS,
					ReturnCode.SUCCESS, "Successful");
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "Employee not found!");
		}
	}

	@PutMapping
	public ApiResponse update(@Valid @RequestBody Employee e, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return validationErrorResponse(bindingResult);
		}

		Employee employee = employeeService.save(e);
		if (employee != null) {
			return new ApiResponse(ClassWrapper.getWrapper("employee", employee)).send(ReturnStatus.SUCCESS,
					ReturnCode.SUCCESS, "Successful");
		} else {
			return new ApiResponse().send(ReturnStatus.NO_SEARCH_RESULT, "Employee not found!");
		}
	}

	public ApiResponse validationErrorResponse(BindingResult bindingResult) {
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		Map<String, String> errors = new HashMap<String, String>();
		for (FieldError error : fieldErrors) {
			System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
			errors.put(error.getField(), error.getDefaultMessage());
		}
		return new ApiResponse(ClassWrapper.getWrapper("errors", errors)).send(ReturnStatus.VALIDATION_ERROR,
				ReturnCode.VALIDATION_ERROR, "Validation Error");

	}
}
