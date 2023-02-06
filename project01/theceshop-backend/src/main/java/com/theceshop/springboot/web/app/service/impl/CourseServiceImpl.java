package com.theceshop.springboot.web.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theceshop.springboot.web.app.entity.Course;
import com.theceshop.springboot.web.app.repository.CourseRepository;
import com.theceshop.springboot.web.app.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public boolean create(Course course) {
		courseRepository.save(course);
		return true;
	}

	@Override
	public Course getById(int courseId) {
		Course course = courseRepository.findById(courseId).orElse(null);
		return course;
	}

	@Override
	public List<Course> getAll() {
		List<Course> courseList = courseRepository.findAll();
		return courseList;
	}

	@Override
	public boolean update(Course course) {
		courseRepository.save(course);
		return true;
	}

	@Override
	public boolean delete(Course course) {
		courseRepository.delete(course);
		return true;
	}

}
