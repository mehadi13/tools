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

import com.bjit.project.controller.CountryController;
import com.bjit.project.model.Country;
import com.bjit.project.service.CountryService;

@RunWith(MockitoJUnitRunner.class)
public class CountryControllerTest {

	@Mock
	CountryService countryService;

	MockMvc mockMvc;


	@InjectMocks
	CountryController countryController;
	
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
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();
	}
	
	@Test
	public void testGetCountrys_shouldPrintCountries() throws Exception {
		Mockito.when(countryService.getAllCountries()).thenReturn(countryList);
		
		mockMvc.perform(post("/allcountries").accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print());
	}
}
