--Create DB
USE master;
GO
CREATE DATABASE theceshopdb;

--Create a table for storing the courses information.
CREATE TABLE courses (
  course_id INT PRIMARY KEY IDENTITY(1, 1),
  course_name VARCHAR(100) NOT NULL,
  total_questions INT NOT NULL
);

--Create a table for storing the students information.
CREATE TABLE students (
  student_id INT PRIMARY KEY IDENTITY(1, 1),
  student_name VARCHAR(100) NOT NULL
);

--Create a table to store the information of students enrollment in courses.
CREATE TABLE student_courses (
  student_course_id INT PRIMARY KEY IDENTITY(1, 1),
  student_id INT NOT NULL,
  course_id INT NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  questions_answered INT NOT NULL,
  FOREIGN KEY (student_id) REFERENCES students(student_id),
  FOREIGN KEY (course_id) REFERENCES courses(course_id)
);


--courses:
INSERT INTO courses (course_name, total_questions) VALUES ('Introduction to Real Estate', 10);
INSERT INTO courses (course_name, total_questions) VALUES ('Property Management', 15);
INSERT INTO courses (course_name, total_questions) VALUES ('Laws and Regulations', 20);
INSERT INTO courses (course_name, total_questions) VALUES ('Marketing and Sales', 25);
INSERT INTO courses (course_name, total_questions) VALUES ('Ethics and Professionalism', 30);

--Students:
INSERT INTO students (student_name) VALUES ('John Doe');
INSERT INTO students (student_name) VALUES ('Jane Doe');
INSERT INTO students (student_name) VALUES ('James Smith');
INSERT INTO students (student_name) VALUES ('Emily Johnson');
INSERT INTO students (student_name) VALUES ('Michael Brown');

--Student_courses:
INSERT INTO student_courses (student_id, course_id, start_date, end_date, questions_answered) VALUES (1, 1, '2022-01-01', '2022-01-15', 3);
INSERT INTO student_courses (student_id, course_id, start_date, end_date, questions_answered) VALUES (2, 2, '2022-02-01', '2022-02-28', 5);
INSERT INTO student_courses (student_id, course_id, start_date, end_date, questions_answered) VALUES (3, 3, '2022-03-01', '2022-03-31', 4);
INSERT INTO student_courses (student_id, course_id, start_date, end_date, questions_answered) VALUES (4, 4, '2022-04-01', '2022-04-30', 2);
INSERT INTO student_courses (student_id, course_id, start_date, end_date, questions_answered) VALUES (5, 5, '2022-05-01', '2022-05-31', 1);
INSERT INTO student_courses (student_id, course_id, start_date, end_date, questions_answered) VALUES (1, 2, '2022-06-01', '2022-06-30', 3);
INSERT INTO student_courses (student_id, course_id, start_date, end_date, questions_answered) VALUES (2, 3, '2022-07-01', '2022-07-31', 4);
INSERT INTO student_courses (student_id, course_id, start_date, end_date, questions_answered) VALUES (3, 4, '2022-08-01', '2022-08-31', 5);
INSERT INTO student_courses (student_id, course_id, start_date, end_date, questions_answered) VALUES (4, 5, '2022-09-01', '2022-09-30', 2);
INSERT INTO student_courses (student_id, course_id, start_date, end_date, questions_answered) VALUES (5, 1, '2022-10-01', '2022-10-31', 3);

-- Query
SELECT
	s.student_name,
	c.course_name,
	(100 * sc.questions_answered)/ c.total_questions  as progress
from
	students s
join student_courses sc on
	s.student_id = sc.student_id
join courses c on
	c.course_id = sc.course_id
WHERE
	s.student_id = 5;
