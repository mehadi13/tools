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

import com.bjit.project.model.Company;
import com.bjit.project.repository.CompanyRepository;
import com.bjit.project.repository.CountryRepository;
import com.bjit.project.service.CompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {
	@MockBean
	private CompanyRepository companyRepository;
	@Autowired
	private CompanyService companyService;

	private static List<Company> companyList = new ArrayList<>();

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

	@Test
	public void testGetAllCompanies_shouldPrintOk() {
		int index = 0;
		when(companyService.getAllCompanies()).thenReturn(companyList);
		List<Company> list = new ArrayList<>();

		companyRepository.findAll().forEach(list::add);
		assertThat(list.get(index).getCompanyName(), equalTo("BJIT"));
	}
}
