package com.bjit.training.employee.restcontroller;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bjit.training.employee.model.DemoEmployee;
import com.bjit.training.employee.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRestControllerIntegrationTest {
	
	private static final String uri = "http://localhost:9070/v1/employees/";
	private static DemoEmployee demoEmployee;
	
	@BeforeClass
	public static void init(){
		demoEmployee = new DemoEmployee();
	}
	
	@Test
	public void shouldReturnListOfEmployee(){
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response = testRestTemplate.
		  getForEntity(uri, String.class);
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode());
		System.out.println(response); 
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void shouldReturnOneEmployee(){
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response = testRestTemplate.
		  getForEntity(uri+"1", String.class);
		System.out.println(response); 
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void shouldStoreEmployee(){
		Employee emp = demoEmployee.getNewEmployee();
		
		RestTemplate rest = new RestTemplate();

	    ResponseEntity<String> response = 
	       rest.postForEntity(uri, emp, String.class);
	    
		System.out.println("Response"+response); 
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void shouldUpdateEmployee(){
		Employee emp = demoEmployee.getExistEmployee();
		emp.setId(1);
		emp.setName("Kalam");
		
		RestTemplate rest = new RestTemplate();
		rest.put("http://localhost:9070/v1/employees",emp);
	}
}
