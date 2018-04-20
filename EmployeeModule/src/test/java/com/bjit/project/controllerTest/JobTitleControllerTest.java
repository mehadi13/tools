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

import com.bjit.project.controller.JobTitleController;
import com.bjit.project.model.JobTitle;
import com.bjit.project.service.JobTitleService;

@RunWith(MockitoJUnitRunner.class)
public class JobTitleControllerTest {
	@Mock
	JobTitleService jobTitleService;

	MockMvc mockMvc;


	@InjectMocks
	JobTitleController jobTitleController;
	
	private static List<JobTitle> jobTitleList = new ArrayList<>();
	
	@BeforeClass
	public static void initJobTitles() {
		JobTitle jobTitle1 = new JobTitle();
		jobTitle1.setId(1);
		jobTitle1.setJobTitleName("SE");
		
		JobTitle jobTitle2 = new JobTitle();
		jobTitle2.setId(2);
		jobTitle2.setJobTitleName("CEO");

		jobTitleList.add(jobTitle1);
		jobTitleList.add(jobTitle2);
	}
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(jobTitleController).build();
	}
	
	@Test
	public void testGetJobTitles_shouldPrintJobTitles() throws Exception {
		Mockito.when(jobTitleService.getAllJobTitles()).thenReturn(jobTitleList);
		
		mockMvc.perform(post("/alljobTitles").accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print());
	}
}
