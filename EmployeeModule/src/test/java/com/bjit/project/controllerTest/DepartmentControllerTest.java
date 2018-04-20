package com.bjit.project.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
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

import com.bjit.project.controller.DepartmentController;
import com.bjit.project.model.Department;
import com.bjit.project.service.DepartmentService;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentControllerTest {
	@Mock
	DepartmentService departmentService;

	MockMvc mockMvc;


	@InjectMocks
	DepartmentController departmentController;
	
	private static List<Department> departmentList = new ArrayList<>();
	
	@BeforeClass
	public static void initDepartments() {
		Department department1 = new Department();
		department1.setId(1);
		department1.setDepartmentName("Sales");
		
		Department department2 = new Department();
		department2.setId(2);
		department2.setDepartmentName("Eng");

		departmentList.add(department1);
		departmentList.add(department2);
	}
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
	}
	
	@Test
	public void testGetDepartments_shouldPrintDepartments() throws Exception {
		Mockito.when(departmentService.getAllDepartments()).thenReturn(departmentList);
		
		mockMvc.perform(post("/alldepartments").accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print());
	}
}
