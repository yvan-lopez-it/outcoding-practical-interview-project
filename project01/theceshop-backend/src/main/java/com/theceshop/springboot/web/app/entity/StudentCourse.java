package com.theceshop.springboot.web.app.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_courses")
public class StudentCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_course_id")
	private int studentCourseId;

	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
	private Student student;

	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
	private Course course;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "end_date", nullable = false)
	private Date endDate;

	@Column(name = "questions_answered", nullable = false)
	private int questionsAnswered;

	public StudentCourse() {
	}

	public StudentCourse(Student student, Course course, Date startDate, Date endDate, int questionsAnswered) {
		this.student = student;
		this.course = course;
		this.startDate = startDate;
		this.endDate = endDate;
		this.questionsAnswered = questionsAnswered;
	}

	public int getStudentCourseId() {
		return studentCourseId;
	}

	public void setStudentCourseId(int studentCourseId) {
		this.studentCourseId = studentCourseId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getQuestionsAnswered() {
		return questionsAnswered;
	}

	public void setQuestionsAnswered(int questionsAnswered) {
		this.questionsAnswered = questionsAnswered;
	}

}
