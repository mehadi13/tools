package com.bjit.project.repositoryTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bjit.project.model.Department;
import com.bjit.project.repository.DepartmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentRepositoryTest {
	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void shouldGetAllDepartments() {
		int index = 0;
		List<Department> departmentList = new ArrayList<>();
		departmentRepository.findAll().forEach(departmentList::add);

		assertThat(departmentList.get(index).getDepartmentName(), equalTo("Management"));
	}
}
