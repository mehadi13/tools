package com.bjit.project.serviceTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bjit.project.controller.DepartmentController;
import com.bjit.project.model.Department;
import com.bjit.project.repository.DepartmentRepository;
import com.bjit.project.service.DepartmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	@MockBean
	private DepartmentRepository departmentRepository;
	
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
	
	@Test
	public void testGetAllDepartments_shouldPrintOk() {
		int index = 0;
		when(departmentService.getAllDepartments()).thenReturn(departmentList);
		List<Department> list = new ArrayList<>();
		
		departmentRepository.findAll().forEach(list::add);
		assertThat(list.get(index).getDepartmentName(), equalTo("Sales"));
	}
}
