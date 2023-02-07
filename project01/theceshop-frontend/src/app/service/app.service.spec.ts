import {TestBed} from '@angular/core/testing';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import {CourseProgressService} from "./app.service";
import {environment} from "../../environments/environment";

describe('CourseProgressService', () => {
  let service: CourseProgressService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseProgressService]
    });

    service = TestBed.inject(CourseProgressService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return a student progress', () => {
    const studentId = 1;
    const courseId = 2;
    const expectedResult = {
      studentName: 'John Doe',
      courseName: 'Angular Fundamentals',
      progress: 66
    };

    service.getStudentProgress(studentId, courseId).subscribe(result => {
      expect(result).toEqual(expectedResult);
    });

    const request = httpTestingController.expectOne(`${environment.apiUrl}${studentId}/${courseId}`);
    expect(request.request.method).toEqual('GET');
    request.flush(expectedResult);
  });
});
