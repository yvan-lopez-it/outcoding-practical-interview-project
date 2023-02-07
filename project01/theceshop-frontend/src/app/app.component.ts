import {Component} from '@angular/core';
import {CourseProgressDto} from "./dto/course-progress-dto";
import {CourseProgressService} from "./service/app.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  courseProgressDto: CourseProgressDto | undefined;
  studentId: number | undefined;
  courseId: number | undefined;

  constructor(private courseProgressService: CourseProgressService) {
  }

  getStudentProgress() {
    this.courseProgressService.getStudentProgress(this.studentId, this.courseId)
      .subscribe((courseProgressDto: CourseProgressDto | undefined) => this.courseProgressDto = courseProgressDto);
  }
}
