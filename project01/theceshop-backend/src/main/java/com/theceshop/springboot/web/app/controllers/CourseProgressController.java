package com.theceshop.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theceshop.springboot.web.app.dto.CourseProgressDto;
import com.theceshop.springboot.web.app.service.StudentCourseService;

@RestController
@RequestMapping("/api/progress")
public class CourseProgressController {
		
	@Autowired
    StudentCourseService studentCourseService;

    public CourseProgressController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @GetMapping("/{studentId}/{courseId}")
    public ResponseEntity<CourseProgressDto> getStudentProgress(
    		@PathVariable int studentId,
            @PathVariable int courseId) {
    	CourseProgressDto courseProgressDto = studentCourseService.calculateStudentProgress(studentId, courseId);
        return ResponseEntity.ok(courseProgressDto);
    }
}
