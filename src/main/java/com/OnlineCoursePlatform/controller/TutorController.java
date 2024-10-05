package com.OnlineCoursePlatform.controller;

import com.OnlineCoursePlatform.model.Course;
import com.OnlineCoursePlatform.model.Tutor;
import com.OnlineCoursePlatform.service.CourseService;
import com.OnlineCoursePlatform.service.TutorService;
import org.hibernate.type.descriptor.jdbc.TimeUtcAsOffsetTimeJdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TutorController {
@Autowired
    private CourseService courseService;

@PostMapping("/courses")
    public Course createCourse(@RequestBody Course course){
    return courseService.createCourse(course);

}
@DeleteMapping("courses/{courseId}")
  public void deleteCourse(@PathVariable Long courseId){
    courseService.deleteCourse(courseId);
}


}
