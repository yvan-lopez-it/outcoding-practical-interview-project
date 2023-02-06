package com.theceshop.springboot.web.app.service;

import com.theceshop.springboot.web.app.dto.CourseProgressDto;

public interface StudentCourseService {
	CourseProgressDto calculateStudentProgress(int studentId, int courseId);
}
