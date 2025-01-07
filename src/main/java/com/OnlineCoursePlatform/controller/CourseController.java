package com.OnlineCoursePlatform.controller;

import com.OnlineCoursePlatform.model.Course;
import com.OnlineCoursePlatform.model.Student;
import com.OnlineCoursePlatform.model.request.CourseCreateRequest;
import com.OnlineCoursePlatform.service.CourseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public  CourseController(CourseService courseService){

        this.courseService = courseService;
    }
    @PostMapping
    @PreAuthorize("hasRole('TUTOR')")
    public ResponseEntity<Course> createCourse(@RequestBody CourseCreateRequest courseCreateRequest) {
        return new ResponseEntity<>(courseService.createCourse(courseCreateRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('TUTOR')")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return ResponseEntity.ok(courseService.updateCourse(id, courseDetails));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('TUTOR')")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/enroll")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<Course> enrollCourse(@PathVariable Long id, @RequestBody Student student) {
        return ResponseEntity.ok(courseService.enrollCourse(id, student));
    }

}

