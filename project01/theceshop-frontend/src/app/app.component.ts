import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";

export class CourseProgressDto {
  studentName: string | undefined;
  courseName: string | undefined;
  progress: number | undefined;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  courseProgressDto: CourseProgressDto | undefined;
  studentId: number | undefined;
  courseId: number | undefined;

  constructor(private http: HttpClient) {
  }

  getStudentProgress() {
    this.http.get<CourseProgressDto>(`http://localhost:8080/api/progress/${this.studentId}/${this.courseId}`)
      .subscribe(courseProgressDto => this.courseProgressDto = courseProgressDto);
  }
}
