package com.theceshop.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/{studentId}/{courseId}")
    public ResponseEntity<CourseProgressDto> getStudentProgress(
    		@PathVariable int studentId,
            @PathVariable int courseId) {
    	CourseProgressDto courseProgressDto = studentCourseService.calculateStudentProgress(studentId, courseId);
        return ResponseEntity.ok(courseProgressDto);
    }
}
