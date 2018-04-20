package com.bjit.training.employee.restcontroller;


import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bjit.training.employee.model.DemoEmployee;
import com.bjit.training.employee.model.Employee;
import com.bjit.training.employee.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRestControllerTest {

	@Mock
	EmployeeService employeeServiceMock;

	MockMvc mockMvc;

	@InjectMocks
	EmployeeRestController employeeRestController;
	
	private static DemoEmployee demoEmployee;
	
	@BeforeClass
	public static void init(){
		demoEmployee = new DemoEmployee();
	}

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(employeeRestController).build();
	}

	@Test
	public void shouldGetListOfEmployee() throws Exception {
		// given
		PageRequest pageRequest = new PageRequest(0, 1);
		List<Employee> employees = demoEmployee.getEmployeeList();
		Page<Employee> page = new PageImpl<Employee>(employees);
		
		// when
		Mockito.when(employeeServiceMock.findAll(pageRequest)).thenReturn(page);
		
		//then
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/employees?page=1&size=1").accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void shouldStoreEmployee() throws Exception {
		// given
		Employee employee = demoEmployee.getNewEmployee();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeAsString = objectMapper.writeValueAsString(employee);
		
		// when
		Mockito.when(employeeServiceMock.save(employee)).thenReturn(employee);
		
		//then
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/employees")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(employeeAsString))
		.andDo(MockMvcResultHandlers.print());	
	}
	
	@Test
	public void shouldUpdateEmployee() throws Exception {
		// given
		Employee employee = demoEmployee.getExistEmployee();
		employee.setName("My name");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeAsString = objectMapper.writeValueAsString(employee);
		System.out.println("JSON:"+employeeAsString);
		
		// when
		Mockito.when(employeeServiceMock.save(employee)).thenReturn(employee);
		
		//then
		mockMvc.perform(MockMvcRequestBuilders.put("/v1/employees")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(employeeAsString))
		.andDo(MockMvcResultHandlers.print());	
	}
	
	@Test
	public void shouldReturnOneEmployee() throws Exception {
		// given
		Employee employee = demoEmployee.getExistEmployee();
		
		// when
		Mockito.when(employeeServiceMock.findOne(1)).thenReturn(employee);
		
		//then
		mockMvc.perform(MockMvcRequestBuilders.get("/v1/employees/1")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print());	
	}
}
