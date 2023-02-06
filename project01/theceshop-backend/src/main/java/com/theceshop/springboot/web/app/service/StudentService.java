package com.theceshop.springboot.web.app.service;

import java.util.List;

import com.theceshop.springboot.web.app.entity.Student;

public interface StudentService {

	boolean create(Student student);

	Student getById(int studentId);

	List<Student> getAll();

	boolean update(Student student);

	boolean delete(Student student);

}
