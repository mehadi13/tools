package com.bjit.training.employee.model;

import java.util.ArrayList;
import java.util.List;

public class DemoEmployee {
	
	
	
	
	private Employee emp(){
		String name = "Mamun";
		String homeAddress = "Baridhara";
		String workAddress = "Baridhara";
		String workEmail = "sdf@sadf.csdf";
		String workPhone = "47548249145";
		String workMobile = "47548249145";
		String bankAccount = "547824587412";
		String workLocation = "gulshan";
		String identificationNo = "14575248245874521";
		
		Department department = new Department();
    	department.setId(1);
    	department.setName("Management");
    	
    	Gender gender = new Gender();
    	gender.setId(1);
    	gender.setName("Male");
    	
    	JobTitle jobTitle = new JobTitle();
    	jobTitle.setId(1);
    	jobTitle.setName("HR");
    	
    	JobType jobType = new JobType();
    	jobType.setId(1);
    	jobType.setName("Full Time");
    	
    	MaritalStatus maritalStatus = new MaritalStatus();
    	maritalStatus.setId(1);
    	maritalStatus.setStatus("Unmarride");
    	
    	Nationality nationality = new Nationality();
    	nationality.setId(1);
    	nationality.setCountry("Bangladesh");
    	
    	Employee employee = new Employee();
    	employee.setName(name);
    	employee.setHomeAddress(homeAddress);
    	employee.setWorkAddress(workAddress);
    	employee.setWorkEmail(workEmail);
    	employee.setWorkPhone(workPhone);
    	employee.setBankaccount(bankAccount);
    	employee.setIdentificationNo(identificationNo);
    	employee.setDepartment(department);
    	employee.setGender(gender);
    	employee.setJobtitle(jobTitle);
    	employee.setJobtype(jobType);
    	employee.setMaritialstatus(maritalStatus);
    	employee.setWorkMobile(workMobile);
    	employee.setWorkLocation(workLocation);
    	employee.setNationality(nationality);
    	
    	return employee;
	}
	
	public List<Employee> getEmployeeList(){
		List<Employee> employees = new ArrayList<>();
		Employee emp = emp();
		emp.setId(1);
		
		
    	employees.add(emp);
		return employees;
	}
	
	public Employee getNewEmployee(){
		return emp();
	}
	
	public Employee getExistEmployee(){
		Employee emp = emp();
		emp.setId(1);
		return emp;
	}
}
