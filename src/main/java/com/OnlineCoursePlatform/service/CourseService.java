package com.OnlineCoursePlatform.service;

import com.OnlineCoursePlatform.exception.ResourceNotFoundException;
import com.OnlineCoursePlatform.model.Course;
import com.OnlineCoursePlatform.model.Student;
import com.OnlineCoursePlatform.model.request.CourseCreateRequest;
import com.OnlineCoursePlatform.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    private final CourseRepository courseRepository;
    private final EnrollmentService enrollmentService;

    public CourseService(CourseRepository courseRepository, EnrollmentService enrollmentService) {
        this.courseRepository = courseRepository;
        this.enrollmentService = enrollmentService;

    }

        public Course createCourse(Course course) {
            return courseRepository.save(course);
        }
        public Course updateCourse(Long id, Course courseDetails) {
            Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
            course.setTitle(courseDetails.getTitle());
            course.setDescription(courseDetails.getDescription());
            return courseRepository.save(course);
        }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        courseRepository.delete(course);
    }

    public List<Course> getAllCourses(Long tutorId) {
        return courseRepository.findAll();
    }

    public Course enrollCourse(Long courseId, Student student) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }


        return course;
    }
}


