package com.theceshop.springboot.web.app.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.theceshop.springboot.web.app.dto.CourseProgressDto;
import com.theceshop.springboot.web.app.service.StudentCourseService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CourseProgressController.class)
public class CourseProgressControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentCourseService studentCourseService;

	@Test
	public void getStudentProgressTest() throws Exception {
		CourseProgressDto courseProgressDto = CourseProgressDto.builder()
				.studentName("John Doe")
				.courseName("Introduction to Real Estate")
				.progress(70.0)
				.build();
		
		when(studentCourseService.calculateStudentProgress(1, 2))
			.thenReturn(courseProgressDto);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/progress/1/2"))
			.andExpect(status().isOk());
	}
}
