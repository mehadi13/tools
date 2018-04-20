package com.bjit.project.repositoryTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import com.bjit.project.model.Employee;
import com.bjit.project.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void shouldGetAllEmployees() {
		int page = 0, size = 5;
		int index = 0;
		List<Employee> employeeList = new ArrayList<>();
		employeeRepository.findAll(new PageRequest(page, size)).forEach(employeeList::add);

		assertThat(employeeList.get(index).getId(), equalTo(3));
	}
	@Test
	public void shouldGetEmployees() {
		int index = 0;
		List<Employee> employeeList = new ArrayList<>();
		employeeRepository.findAll().forEach(employeeList::add);

		assertThat(employeeList.get(index).getId(), equalTo(3));
	}
	@Test
	public void shouldGetAllEmployeeNames() {
		List<String> names = employeeRepository.findAllNames();
		assertThat(names.get(1), equalTo("Touhid"));
	}

	@Test
	public void shouldGetEmployeeById() {
		Employee employee = employeeRepository.findOne(3);
		assertThat(employee.getId(), equalTo(3));
	}
}