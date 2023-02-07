# Frontend: Let's see the data!

- The component has three properties: `courseProgressDto`, `studentId`, and `courseId`. `courseProgressDto` is the object that will hold the student's course progress information. 
`studentId` and `courseId` are the parameters that will be used to identify the student and course in question.

- In the constructor, the component creates an instance of the `CourseProgressService`, which is a service that provides the logic to retrieve the student's progress.

- The `getStudentProgress()` method is called when the user wants to retrieve the student's progress.
- It calls the `getStudentProgress()` method of the `CourseProgressService`, passing in the `studentId` and courseId `properties` as parameters.

- The result of the `getStudentProgress()` call is subscribed to and the returned `courseProgressDto` is assigned to the component's `courseProgressDto` property.
- This updates the component's state and allows the updated progress information to be displayed in the HTML template.

## About the `getStudentProgress()` method:
This method will get the student progress in a particular course. 

- The `getStudentProgress` function is a public function of the `courseProgressService` which is a class that implements the Angular service.

- The function takes in two optional parameters `studentId` and `courseId` with a default value of `0`. 
It returns an `Observable` of type `CourseProgressDto` which is an interface that represents the data structure for the course progress.

- The function uses the `http.get` method from the `HttpClient` module provided by Angular to make a GET request to the API endpoint specified in the `environment.apiUrl` constant, 
which is a URL pointing to the API service that returns the student's course progress information. 

- The URL is constructed by concatenating the API endpoint with the `studentId` and `courseId` parameters. 
- The `http.get` method returns an observable of the expected data type, which is `CourseProgressDto` in this case.

![webapp](https://user-images.githubusercontent.com/96596558/217150065-e1093bd6-7d34-408c-91b1-989ac7cee8a3.jpg)
