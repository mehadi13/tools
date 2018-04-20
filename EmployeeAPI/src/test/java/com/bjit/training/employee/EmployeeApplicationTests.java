package com.bjit.training.employee;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bjit.training.employee.restcontroller.EmployeeRestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeApplicationTests {

	@Autowired
	private EmployeeRestController employeeRestController;
	@Test
	public void contextLoads() {
		Assert.assertNotNull(employeeRestController);
	}

}
