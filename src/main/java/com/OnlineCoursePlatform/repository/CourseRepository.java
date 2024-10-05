package com.OnlineCoursePlatform.repository;

import com.OnlineCoursePlatform.model.Course;
import com.OnlineCoursePlatform.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository< Course, Long> {
    Optional<Tutor> findByTutorName(Long name);
}
