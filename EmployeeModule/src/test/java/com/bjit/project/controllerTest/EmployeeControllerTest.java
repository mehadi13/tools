package com.bjit.project.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


import com.bjit.project.controller.EmployeeController;
import com.bjit.project.model.Employee;
import com.bjit.project.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	@Mock
	EmployeeService employeeService;

	MockMvc mockMvc;

	static private Employee employee;
	static private File file;

	@InjectMocks
	EmployeeController employeeController;

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

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}

	@Test
	public void testshowEmployees() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("showEmployees_page"))
				.andDo(print());
	}

	@Test
	public void testGetEmployeeListPage() throws Exception {
		this.mockMvc.perform(get("/employeelist-page")).andExpect(status().isOk())
				.andExpect(view().name("showEmployees_partial_page")).andDo(print());
	}

	@Test
	public void testGetEmployees_shouldPrintEmployeeList() throws Exception {
		int page = 0, size = 5;
		Mockito.when(employeeService.getAllEmployees(page, size)).thenReturn(employeeList);
		mockMvc.perform(post("/allemployees/{page}", page).accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testGetEmployeeDetailsPage() throws Exception {
		this.mockMvc.perform(get("/employeedetals-page")).andExpect(status().isOk())
				.andExpect(view().name("showDetails/showEmployeeDetails_partial_page")).andDo(print());
	}

	@Test
	public void testGetEmployeeDetail_shouldPrintEmployeeDetails() throws Exception {
		when(employeeService.getEmployee(1)).thenReturn(employeeList.get(0));
		mockMvc.perform(post("/employees/employeedetails/{employeeId}",1).accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testGetNewEmployeePage() throws Exception {
		this.mockMvc.perform(get("/newemployee-page")).andExpect(status().isOk())
				.andExpect(view().name("new/newEmployeeForm_partial_page")).andDo(print());
	}
	
	@Test
	public void testGetEmployeeNames_shoudPrintAllEmployeeNames() throws Exception {
		when(employeeService.getAllEmployeeNames()).thenReturn(employeeNames);
		mockMvc.perform(get("/allemployeenames").accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testGetEditEmployeePage() throws Exception {
		this.mockMvc.perform(get("/editemployee-page")).andExpect(status().isOk())
				.andExpect(view().name("edit/editEmployeeForm_partial_page")).andDo(print());
	}
	
	@Before
	public void createMockEmployee() {
		Employee employee3 = new Employee();
		employee3.setEmployeeName("Riyad");
		employee3.setWorkEmail("t2@t.com");
		employee3.setWorkingAddress("BJIT2");
		employee3.setWorkLocation("Dhaka2");
		employee3.setWorkMobile("12312");
		employee3.setWorkPhone("342");
		employee3.setWorkType("Full Time");
		employee3.setDepartment("Sales");
		employee3.setJobTitle("Trainee");
		employee3.setNationality("Bangladesh");
		Date date3 = new Date();
		employee3.setDateOfBirth(date3);
		
		employee = employee3;
	}
	
	@Test
	public void testCreateEmployee_shouldPrintErrorMessages() throws Exception {
		mockMvc.perform(post("/employees/createemployee").accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testCreateEmployee_shouldPrintNoErrorMessages() throws Exception {
		mockMvc.perform(post("/employees/createemployee/{employee}",employee).accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Before
	public void createMockPicure() {
		file = new File("/home/hp/eclipse-workspace/EmployeeModule/src/main/resources/static/employee-photo/employeeTest.jpg");
	}
	
	@Test
	public void testCreateProfilePicture_shouldPrintNoError() throws Exception {
		mockMvc.perform(post("/create-profile-picture/{file}",file).accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testCreateCustomFileName() throws Exception {
		String oldName = "abcd.jpg";
		String newName = employeeController.createCustomFileName(oldName);
		String array[] = newName.split("\\.");
		assertThat(array[array.length-1], equalTo("jpg"));
	}
}