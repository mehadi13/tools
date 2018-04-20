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

import com.bjit.project.model.Country;
import com.bjit.project.repository.CountryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryRepositoryTest {
	@Autowired
	private CountryRepository countryRepository;

	@Test
	public void shouldGetAllCountries() {
		int index = 0;
		List<Country> countryList = new ArrayList<>();
		countryRepository.findAll().forEach(countryList::add);

		assertThat(countryList.get(index).getCountryName(), equalTo("Afghanistan"));
	}
}

