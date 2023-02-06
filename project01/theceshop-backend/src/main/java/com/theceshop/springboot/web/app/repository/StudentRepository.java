package com.theceshop.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.theceshop.springboot.web.app.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
