package com.OnlineCoursePlatform.controller;

import com.OnlineCoursePlatform.model.Enrollment;
import com.OnlineCoursePlatform.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnrollmentController {
@Autowired
    private EnrollmentService enrollmentService;

@GetMapping
    public List<Enrollment> getAllEnrollment(){
    return enrollmentService.getAllEnrollments();
}

@PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment){
    return enrollmentService.addEnrollment(enrollment);
}
}
