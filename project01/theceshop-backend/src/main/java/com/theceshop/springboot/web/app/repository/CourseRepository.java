package com.theceshop.springboot.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theceshop.springboot.web.app.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	List<Course> findByCourseName(String courseName);

}
