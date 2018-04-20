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

import com.bjit.project.model.Company;
import com.bjit.project.repository.CompanyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyRepositoryTest {
	@Autowired
	private CompanyRepository companyRepository;

	@Test
	public void shouldGetAllCompanies() {
		int index = 0;
		List<Company> companyList = new ArrayList<>();
		companyRepository.findAll().forEach(companyList::add);

		assertThat(companyList.get(index).getCompanyName(), equalTo("BJIT"));
	}
}
