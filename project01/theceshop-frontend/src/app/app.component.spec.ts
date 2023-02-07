import {TestBed} from '@angular/core/testing';
import {AppComponent} from './app.component';
import {CourseProgressService} from "./service/app.service";
import {of} from "rxjs";

describe('AppComponent', () => {

  let courseProgressServiceSpy: jasmine.SpyObj<CourseProgressService>;


  beforeEach(async () => {
    const spy = jasmine.createSpyObj('CourseProgressService', ['getStudentProgress']);

    await TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
      providers: [
        {provide: CourseProgressService, useValue: spy}
      ]
    }).compileComponents();
    courseProgressServiceSpy = TestBed.get(CourseProgressService);
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should call the getStudentProgress method of the course progress service', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    app.studentId = 1;
    app.courseId = 2;

    const courseProgressDto = {
      studentName: 'John Doe',
      courseName: 'Angular Fundamentals',
      progress: 80
    };
    courseProgressServiceSpy
      .getStudentProgress
      .and
      .returnValue(of(courseProgressDto));

    app.getStudentProgress();

    expect(courseProgressServiceSpy.getStudentProgress).toHaveBeenCalledWith(1, 2);
    expect(app.courseProgressDto).toEqual(courseProgressDto);
  });
});
