package com.OnlineCoursePlatform.repository;


import com.OnlineCoursePlatform.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
