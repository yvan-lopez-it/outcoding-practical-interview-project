package com.theceshop.springboot.web.app.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.theceshop.springboot.web.app.dto.CourseProgressDto;
import com.theceshop.springboot.web.app.entity.Course;
import com.theceshop.springboot.web.app.entity.Student;
import com.theceshop.springboot.web.app.entity.StudentCourse;
import com.theceshop.springboot.web.app.repository.CourseRepository;
import com.theceshop.springboot.web.app.repository.StudentCourseRepository;
import com.theceshop.springboot.web.app.repository.StudentRepository;

@RunWith(MockitoJUnitRunner.class)
public class StudentCourseServiceImplTest {

	@Mock
	private StudentCourseRepository studentCourseRepository;

	@Mock
	private CourseRepository courseRepository;

	@Mock
	private StudentRepository studentRepository;

	@InjectMocks
	private StudentCourseServiceImpl studentCourseServiceImpl;

	private StudentCourse studentCourse;
	private Course course;
	private Student student;

	@Before
	public void setUp() {
		student = new Student();
		student.setStudentId(1);
		student.setStudentName("John Doe");

		course = new Course();
		course.setCourseId(1);
		course.setCourseName("Real Estate 101");
		course.setTotalQuestions(10);

		studentCourse = new StudentCourse();
		studentCourse.setStudent(student);
		studentCourse.setCourse(course);
		studentCourse.setQuestionsAnswered(4);
	}

	@Test
    public void testCalculateStudentProgress() {
        when(studentRepository.findById(1)).thenReturn(Optional.of(student));
        when(courseRepository.findById(1)).thenReturn(Optional.of(course));
        when(studentCourseRepository.findByStudentIdAndCourseId(1, 1)).thenReturn(studentCourse);

        CourseProgressDto courseProgressDto = studentCourseServiceImpl.calculateStudentProgress(1, 1);

        assertEquals("John Doe", courseProgressDto.getStudentName());
        assertEquals("Real Estate 101", courseProgressDto.getCourseName());
        assertEquals(40.0, courseProgressDto.getProgress(), 0);
    }

}
