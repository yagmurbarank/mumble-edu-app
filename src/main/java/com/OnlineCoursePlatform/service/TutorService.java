package com.OnlineCoursePlatform.service;


import com.OnlineCoursePlatform.model.Tutor;
import com.OnlineCoursePlatform.repository.TutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TutorService {
    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository){

        this.tutorRepository=tutorRepository;
   }

    public List<Tutor> getAllTutors(){

        return tutorRepository.findAll();
    }

    public Tutor saveTutor(Tutor tutor){

        return tutorRepository.save(tutor);
    }

}
