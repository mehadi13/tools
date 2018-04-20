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

import com.bjit.project.model.JobTitle;
import com.bjit.project.repository.JobTitleRepository;
import com.bjit.project.service.JobTitleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobTitleServiceTest {

	private static List<JobTitle> jobTitleList = new ArrayList<>();
	
	@MockBean
	private JobTitleRepository jobTitleRepository;
	@Autowired
	private JobTitleService jobTitleService;

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
	
	@Test
	public void testGetAllJobTitles_shouldPrintOk() {
		int index = 0;
		when(jobTitleService.getAllJobTitles()).thenReturn(jobTitleList);
		List<JobTitle> list = new ArrayList<>();
		
		jobTitleRepository.findAll().forEach(list::add);
		assertThat(list.get(index).getJobTitleName(), equalTo("SE"));
	}
}
