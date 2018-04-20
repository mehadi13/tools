package com.bjit.project.serviceTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import com.bjit.project.model.Employee;
import com.bjit.project.service.EmployeeService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	
	@MockBean
	private EmployeeService employeeService;
	
	private static Employee employee;
	
	private static List<Employee> employeeList = new ArrayList<>();
	private static List<String> employeeNames = new ArrayList<>();
	
	@BeforeClass
	public static void initEmployeeList() {
		Employee employee1 = new Employee();
		employee1.setId(1);
		employee1.setEmployeeName("Touhid");
		employee1.setWorkEmail("t@t.com");
		employee1.setWorkingAddress("BJIT");
		employee1.setWorkLocation("Dhaka");
		employee1.setWorkMobile("1231");
		employee1.setWorkPhone("2132");
		employee1.setWorkType("Part Time");
		employee1.setDepartment("Sales");
		employee1.setJobTitle("Trainee");
		employee1.setNationality("Bangladesh");
		Date date = new Date();
		employee1.setDateOfBirth(date);
		
		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setEmployeeName("Imti");
		employee2.setWorkEmail("t@t.com");
		employee2.setWorkingAddress("BJIT");
		employee2.setWorkLocation("Dhaka");
		employee2.setWorkMobile("1231");
		employee2.setWorkPhone("2132");
		employee2.setWorkType("Part Time");
		employee2.setDepartment("Sales");
		employee2.setJobTitle("Trainee");
		employee2.setNationality("Bangladesh");
		Date date2 = new Date();
		employee2.setDateOfBirth(date2);

		employeeList.add(employee1);
		employeeList.add(employee2);
		
		for (Employee em : employeeList) {
			employeeNames.add(em.getEmployeeName());
		}
	}
	
	
	@Test
	public void testGetAllEmployees_shouldPrintOk() {
		int page = 0, size = 5;
		int index = 0, id = 1;
		
		when(employeeService.getAllEmployees(page, size)).thenReturn(employeeList);
		List<Employee> list = new ArrayList<>();
		
		employeeService.getAllEmployees(page, size).forEach(list::add);
		assertThat(list.get(index).getId(), equalTo(id));
	}
	
//	@Test
//	public void testGetAllEmployeeNames_shouldPrintOk() {
//		int index = 0;
//		when(employeeService.getAllEmployeeNames()).thenReturn(employeeNames);
//		List<String> names = new ArrayList<>();
//		
//		employeeService.getAllEmployeeNames().forEach(names::add);
//		assertThat(names.get(index), equalTo("Touhid"));
//	}
//	
//	@Test
//	public void testGetEmployee_shouldPrintOk() {
//		int index = 0, id = 1;
//		when(employeeService.getEmployee(id)).thenReturn(employeeList.get(index));
//		Employee employee = employeeService.getEmployee(id);
//		assertThat(employee.getId(), equalTo(id));
//	}
//	
//	@Before
//	public void createMockEmployee() {
//		Employee employee3 = new Employee();
//		employee3.setEmployeeName("Riyad");
//		employee3.setWorkEmail("t2@t.com");
//		employee3.setWorkingAddress("BJIT2");
//		employee3.setWorkLocation("Dhaka2");
//		employee3.setWorkMobile("12312");
//		employee3.setWorkPhone("342");
//		employee3.setWorkType("Full Time");
//		employee3.setDepartment("Sales");
//		employee3.setJobTitle("Trainee");
//		employee3.setNationality("Bangladesh");
//		Date date3 = new Date();
//		employee3.setDateOfBirth(date3);
//		
//		employee = employee3;
//	}
//	
//	@Test
//	public void testCreateEmployee_shouldPrintOk() {
//		employeeService.createEmployee(employee);
//	}
}