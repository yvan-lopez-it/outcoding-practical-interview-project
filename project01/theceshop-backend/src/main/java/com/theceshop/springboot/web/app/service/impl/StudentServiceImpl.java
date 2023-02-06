package com.theceshop.springboot.web.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theceshop.springboot.web.app.entity.Student;
import com.theceshop.springboot.web.app.repository.StudentRepository;
import com.theceshop.springboot.web.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public boolean create(Student student) {
		studentRepository.save(student);
		return true;
	}

	@Override
	public Student getById(int studentId) {
		Student student = studentRepository.findById(studentId).orElse(null);
		return student;
	}

	@Override
	public List<Student> getAll() {
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}

	@Override
	public boolean update(Student student) {
		studentRepository.save(student);
		return true;
	}

	@Override
	public boolean delete(Student student) {
		studentRepository.delete(student);
		return true;
	}

}
