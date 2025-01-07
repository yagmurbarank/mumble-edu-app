package com.OnlineCoursePlatform.controller;

import com.OnlineCoursePlatform.model.Course;
import com.OnlineCoursePlatform.model.Enrollment;
import com.OnlineCoursePlatform.service.CourseService;
import com.OnlineCoursePlatform.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public StudentController(CourseService courseService, EnrollmentService enrollmentService) {
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/{id}/courses")
    public List<Course> getAllCourses(@PathVariable Long tutorId) {

        return courseService.getAllCourses(tutorId);
    }

    @GetMapping("/{id}/enrolled-courses")
    public List<Course> getEnrolledCourses(@PathVariable Long id) {
        return enrollmentService.getEnrolledCoursesByStudentId(id);
    }

    @PostMapping("/{id}/enroll")
    public Enrollment enrollInCourse(@PathVariable Long id, @RequestParam Long courseId) {
        return enrollmentService.enrollStudent(courseId, id);
    }

    @DeleteMapping("/{id}/withdrawCourse")
    public ResponseEntity<Void> withdrawCourseFromCourses(@PathVariable Long id, @RequestParam Long courseId) {
        enrollmentService.withdrawCourse(courseId, id);
        return ResponseEntity.noContent().build();

    }


}
