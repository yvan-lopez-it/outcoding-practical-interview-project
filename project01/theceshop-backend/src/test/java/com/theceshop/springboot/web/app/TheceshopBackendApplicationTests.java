package com.theceshop.springboot.web.app;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.theceshop.springboot.web.app.controllers.CourseProgressController;
import com.theceshop.springboot.web.app.dto.CourseProgressDto;
import com.theceshop.springboot.web.app.service.StudentCourseService;

@SpringBootTest
class TheceshopBackendApplicationTests {

	@Autowired
	private CourseProgressController courseProgressController;

	@MockBean
	private StudentCourseService studentCourseService;

	@Test
	public void testGetStudentProgress() {
		// Given
		int studentId = 1;
		int courseId = 2;

		CourseProgressDto expectedCourseProgressDto = CourseProgressDto.builder()
				.studentName("John Doe")
				.courseName("Real Estate Fundamentals")
				.progress(40.0)
				.build();

		// When
		Mockito.when(studentCourseService.calculateStudentProgress(studentId, courseId))
				.thenReturn(expectedCourseProgressDto);

		ResponseEntity<CourseProgressDto> response = courseProgressController.getStudentProgress(studentId, courseId);

		// Then
		assertEquals(expectedCourseProgressDto, response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void contextLoads() {
	}

}
