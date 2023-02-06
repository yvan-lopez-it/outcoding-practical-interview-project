package com.theceshop.springboot.web.app.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CourseProgressDto {

	private String studentName;
	private String courseName;
	private double progress;
	
	public CourseProgressDto(String studentName, String courseName, double progress) {
		super();
		this.studentName = studentName;
		this.courseName = courseName;
		this.progress = progress;
	}
	
	

}
