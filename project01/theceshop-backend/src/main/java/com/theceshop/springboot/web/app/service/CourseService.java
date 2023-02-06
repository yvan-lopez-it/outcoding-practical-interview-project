package com.theceshop.springboot.web.app.service;

import java.util.List;

import com.theceshop.springboot.web.app.entity.Course;

public interface CourseService {

	boolean create(Course course);

	Course getById(int courseId);

	List<Course> getAll();

	boolean update(Course course);

	boolean delete(Course course);

}
