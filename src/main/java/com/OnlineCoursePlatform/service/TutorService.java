package com.OnlineCoursePlatform.service;

import com.OnlineCoursePlatform.model.Course;
import com.OnlineCoursePlatform.model.Tutor;
import com.OnlineCoursePlatform.repository.CourseRepository;
import com.OnlineCoursePlatform.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
    @Autowired
    private TutorRepository tutorRepository;

    public List<Tutor> getAllTutors(){
        return tutorRepository.findAll();
    }

    public Tutor saveTutor(Tutor tutor){
        return tutorRepository.save(tutor);
    }

}
