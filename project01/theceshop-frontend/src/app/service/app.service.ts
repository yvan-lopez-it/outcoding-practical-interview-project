import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CourseProgressDto} from '../dto/course-progress-dto';
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CourseProgressService {

  constructor(private http: HttpClient) {
  }

  getStudentProgress(studentId: number = 0, courseId: number = 0): Observable<CourseProgressDto> {
    return this.http.get<CourseProgressDto>(`${environment.apiUrl}${studentId}/${courseId}`);
  }
}
