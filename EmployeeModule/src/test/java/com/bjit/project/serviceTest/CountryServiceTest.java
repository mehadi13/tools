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

import com.bjit.project.model.Country;
import com.bjit.project.repository.CountryRepository;
import com.bjit.project.service.CountryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryServiceTest {

	@MockBean
	private CountryRepository countryRepository;
	@Autowired
	private CountryService countryService;

	private static List<Country> countryList = new ArrayList<>();

	@BeforeClass
	public static void initCountries() {
		Country country1 = new Country();
		country1.setId(1);
		country1.setCountryName("BD");

		Country country2 = new Country();
		country2.setId(2);
		country2.setCountryName("UK");

		countryList.add(country1);
		countryList.add(country2);
	}

	@Test
	public void testGetAllCountries_shouldPrintOk() {
		int index = 0;
		when(countryService.getAllCountries()).thenReturn(countryList);
		List<Country> list = new ArrayList<>();

		countryRepository.findAll().forEach(list::add);
		assertThat(list.get(index).getCountryName(), equalTo("BD"));
	}
}
