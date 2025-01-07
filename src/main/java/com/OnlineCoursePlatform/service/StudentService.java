package com.OnlineCoursePlatform.service;


import com.OnlineCoursePlatform.model.Student;
import com.OnlineCoursePlatform.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository, CourseService courseService){
        this.studentRepository=studentRepository;
    }

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
