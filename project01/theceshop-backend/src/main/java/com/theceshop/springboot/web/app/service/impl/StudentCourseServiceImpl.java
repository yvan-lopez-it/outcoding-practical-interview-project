package com.theceshop.springboot.web.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theceshop.springboot.web.app.dto.CourseProgressDto;
import com.theceshop.springboot.web.app.entity.Course;
import com.theceshop.springboot.web.app.entity.Student;
import com.theceshop.springboot.web.app.entity.StudentCourse;
import com.theceshop.springboot.web.app.repository.CourseRepository;
import com.theceshop.springboot.web.app.repository.StudentCourseRepository;
import com.theceshop.springboot.web.app.repository.StudentRepository;
import com.theceshop.springboot.web.app.service.StudentCourseService;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Autowired
	private StudentCourseRepository studentCourseRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public CourseProgressDto calculateStudentProgress(int studentId, int courseId) {
		StudentCourse studentCourse = studentCourseRepository.findByStudentIdAndCourseId(studentId, courseId);

		Course course = courseRepository.findById(courseId).orElse(null);
		Student student = studentRepository.findById(studentId).orElse(null);

		int totalQuestions = course.getTotalQuestions();
		int questionsAnswered = studentCourse.getQuestionsAnswered();

		double studentProgress = (questionsAnswered * 100) / totalQuestions;

		CourseProgressDto courseProgressDto = CourseProgressDto.builder().studentName(student.getStudentName())
				.courseName(course.getCourseName()).progress(studentProgress).build();

		return courseProgressDto;
	}

}
