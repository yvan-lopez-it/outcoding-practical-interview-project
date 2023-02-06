import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

export class CourseProgressDto {
  studentName: string | undefined;
  courseName: string | undefined;
  progress: number | undefined;
}

@Component({
  selector: 'app-course-progress',
  template: `
    <div *ngIf="courseProgressDto">
      <p>Student Name: {{ courseProgressDto.studentName }}</p>
      <p>Course Name: {{ courseProgressDto.courseName }}</p>
      <p>Progress: {{ courseProgressDto.progress }}%</p>
    </div>
  `
})
export class AppComponent implements OnInit {
  courseProgressDto: CourseProgressDto | undefined;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    const studentId = 1;
    const courseId = 2;
    this.http.get<CourseProgressDto>(`/api/progress/${studentId}/${courseId}`)
      .subscribe(courseProgressDto => this.courseProgressDto = courseProgressDto);
  }
}
