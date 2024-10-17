package com.OnlineCoursePlatform.controller;

import com.OnlineCoursePlatform.model.Course;
import com.OnlineCoursePlatform.model.Enrollment;
import com.OnlineCoursePlatform.service.CourseService;
import com.OnlineCoursePlatform.service.EnrollmentService;
import com.OnlineCoursePlatform.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private StudentService studentService;
    private CourseService courseService;
    private EnrollmentService enrollmentService;


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

        @DeleteMapping("/{id}/unenroll")
        public ResponseEntity<Void> unenrollFromCourse(@PathVariable Long id, @RequestParam Long courseId) {
            enrollmentService.unenrollStudent(courseId, id);
            return ResponseEntity.noContent().build();

    }


    }
