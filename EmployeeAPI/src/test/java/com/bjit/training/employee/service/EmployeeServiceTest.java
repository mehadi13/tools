package com.bjit.training.employee.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.bjit.training.employee.model.DemoEmployee;
import com.bjit.training.employee.model.Employee;
import com.bjit.training.employee.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepositoryMock;

	@Mock
	private Employee employeeMock;

	@InjectMocks
	private EmployeeService employeeService;
	
	@Autowired
	private static DemoEmployee demoEmployee;

	@Before
	public void setUp(){
		demoEmployee = new DemoEmployee();
	}
	
	@Test
	public void shouldFindAllEmployee() {
		//given
		PageRequest pageRequest = new PageRequest(1, 1);
		List<Employee> employees = demoEmployee.getEmployeeList();
		Page<Employee> page = new PageImpl<>(employees);
		
		//when
		Mockito.when(employeeRepositoryMock.findAll(pageRequest)).thenReturn(page);

		//then
		Page<Employee> employeePage = employeeRepositoryMock.findAll(pageRequest);
		assertEquals(page, employeePage);
	}
	
	@Test
	public void shouldUpdateEmployee(){
		//given
		Employee existEmployee = demoEmployee.getExistEmployee();
		existEmployee.setName("A");
		
		//when
		Mockito.when(employeeRepositoryMock.save(existEmployee)).thenReturn(existEmployee);
		
		//then
		Employee updatedEmployee = employeeRepositoryMock.save(existEmployee);
		assertEquals(existEmployee, updatedEmployee);
	}
	
	@Test
	public void shouldSaveEmployee(){
		//given
    	Employee newEmployee = demoEmployee.getNewEmployee();
    	newEmployee.setName("AB");
		
		//when
		Mockito.when(employeeRepositoryMock.save(newEmployee)).thenReturn(newEmployee);
		
		//then
		Employee createdEmployee = employeeRepositoryMock.save(newEmployee);
		assertEquals(newEmployee.getName(), createdEmployee.getName());
	}
	
	@Test
	public void shouldGetOneEmployee(){
		//given
		Employee existEmployee = demoEmployee.getExistEmployee();
		
		//when
		Mockito.when(employeeRepositoryMock.findOne(1)).thenReturn(existEmployee);
		
		//then
		Employee emp = employeeRepositoryMock.findOne(1);
		assertEquals(existEmployee, emp);
	}

}
