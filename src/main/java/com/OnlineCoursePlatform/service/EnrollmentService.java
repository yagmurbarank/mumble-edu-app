package com.OnlineCoursePlatform.service;

import com.OnlineCoursePlatform.exception.ResourceNotFoundException;
import com.OnlineCoursePlatform.model.Course;
import com.OnlineCoursePlatform.model.Enrollment;
import com.OnlineCoursePlatform.model.Student;
import com.OnlineCoursePlatform.repository.CourseRepository;
import com.OnlineCoursePlatform.repository.EnrollmentRepository;
import com.OnlineCoursePlatform.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Date.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Date.*;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

@Autowired
private EnrollmentRepository enrollmentRepository;
private final CourseRepository courseRepository;
private final StudentRepository studentRepository;

    public List<Enrollment> getAllEnrollments(){
        return enrollmentRepository.findAll();
    }
    public Enrollment addEnrollment(Enrollment enrollment){
        return enrollmentRepository.save(enrollment);
    }
    public void deleteEnrollment(Long enrollmentId){
        enrollmentRepository.deleteById(enrollmentId);
    }
    public List<Course> getEnrolledCoursesByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        List<Enrollment> enrollments = enrollmentRepository.findByStudent(student);
        if (enrollments == null || enrollments.isEmpty()) {
            throw new ResourceNotFoundException("No enrollments found for this student");
        }
        return enrollments.stream()
                .map(Enrollment::getCourse)
                .collect(Collectors.toList());
    }


    public Enrollment enrollStudent(Long courseId, Long studentId) {
            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

            Enrollment enrollment = new Enrollment();
            enrollment.setCourse(course);
            enrollment.setStudent(student);
            enrollment.setEnrollmentDate(LocalDate.now());

            return enrollmentRepository.save(enrollment);
        }
    public void unenrollStudent(Long courseId, Long studentId) {
        Enrollment enrollment = enrollmentRepository.findByCourseIdAndStudentId(courseId, studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));
        enrollmentRepository.delete(enrollment);
    }

    }



