package com.OnlineCoursePlatform.controller;

import com.OnlineCoursePlatform.model.Course;
import com.OnlineCoursePlatform.service.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TutorController {

    private final CourseService courseService;

    public TutorController(CourseService courseService) {

        this.courseService = courseService;
    }


    @GetMapping("courses/{courseId}")
    public void getAllCoursesbyTutorId(@PathVariable Long tutorId) {

        courseService.getAllCourses(tutorId);
    }

    @DeleteMapping("courses/{courseId}")
    public void deleteCourse(@PathVariable Long courseId) {

        courseService.deleteCourse(courseId);
    }


}
