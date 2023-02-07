# Backend: The business logic

Probably the most important thing is to explain the logic that I used in the method `calculateStudentProgress`

It calculates the progress of a student in a course. It takes two parameters: `studentId` and `courseId`.

It starts by searching the student and course records based on the `studentId` and `courseId` respectively.

- If the student is not found, it returns a `CourseProgressDto` object with the `studentName` as "STUDENT\_NOT\_FOUND", `courseName` as an empty string, and `progress` as -1.0.
- If the course is not found, it returns a `CourseProgressDto` object with the `studentName` as the name of the student, `courseName` as "COURSE\_NOT\_EXIST", and `progress` as -2.0.
- If the record of the student's enrollment in the course is not found, it returns a `CourseProgressDto` object with the `studentName` as the name of the student, `courseName` as "COURSE\_NOT\_FOUND", and `progress` as -3.0.
- If the records of both the student and course are found, it calculates the progress by dividing the `questionsAnswered` by `totalQuestions` and multiplying by 100. The resulting value is then used as the `progress` field in the `CourseProgressDto` object. The method then returns the `CourseProgressDto` object that contains the student name, course name, and the calculated progress.
