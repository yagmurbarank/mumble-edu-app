package com.OnlineCoursePlatform.service;


import com.OnlineCoursePlatform.model.Student;
import com.OnlineCoursePlatform.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private CourseService courseService;


    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }
    public Student saveStudent(Student student){

        return studentRepository.save(student);
    }
    public Student getStudentById(Long id) {

        return studentRepository.findById(id).orElseThrow();
    }



}
