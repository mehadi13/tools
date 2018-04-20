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

import com.bjit.project.controller.CompanyController;
import com.bjit.project.model.Company;
import com.bjit.project.service.CompanyService;

@RunWith(MockitoJUnitRunner.class)
public class CompanyControllerTest {

	@Mock
	CompanyService companyService;

	MockMvc mockMvc;


	@InjectMocks
	CompanyController companyController;
	
	private static List<Company>companyList = new ArrayList<>();
	
	@BeforeClass
	public static void initDepartments() {
		Company company1 = new Company();
		company1.setId(1);
		company1.setCompanyName("BJIT");
		
		Company company2 = new Company();
		company2.setId(2);
		company2.setCompanyName("Therap");

		companyList.add(company1);
		companyList.add(company2);
	}
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
	}
	
	@Test
	public void testGetCompanies_shouldPrintCompanies() throws Exception {
		Mockito.when(companyService.getAllCompanies()).thenReturn(companyList);
		
		mockMvc.perform(post("/allcompanies").accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print());
	}
}
