package com.theceshop.springboot.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.theceshop.springboot.web.app.entity.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {

	@Query(value = "SELECT * FROM student_courses sc WHERE sc.student_id = ?1 AND sc.course_id = ?2", nativeQuery = true)
	StudentCourse findByStudentIdAndCourseId(int studentId, int courseId);

}
