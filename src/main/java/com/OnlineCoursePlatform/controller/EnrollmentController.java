package com.OnlineCoursePlatform.controller;

import com.OnlineCoursePlatform.model.Enrollment;
import com.OnlineCoursePlatform.service.EnrollmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {

        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/{id}/enroll")
    @PreAuthorize("hasRole('STUDENT')")
    public List<Enrollment> getAllEnrollment() {
        return enrollmentService.getAllEnrollments();
    }

    @PostMapping("/{id}/enroll")
    @PreAuthorize("hasRole('STUDENT')")
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.addEnrollment(enrollment);
    }
}
