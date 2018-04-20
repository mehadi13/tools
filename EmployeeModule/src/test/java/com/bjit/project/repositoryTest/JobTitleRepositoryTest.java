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

import com.bjit.project.model.JobTitle;
import com.bjit.project.repository.JobTitleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobTitleRepositoryTest {
	@Autowired
	private JobTitleRepository jobTitleRepository;

	@Test
	public void shouldGetAllJobTitles() {
		int index = 0;
		List<JobTitle> jobTitleList = new ArrayList<>();
		jobTitleRepository.findAll().forEach(jobTitleList::add);

		assertThat(jobTitleList.get(index).getJobTitleName(), equalTo("Chief Executive Officer"));
	}
}
