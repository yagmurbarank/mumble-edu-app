package com.OnlineCoursePlatform.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Tutor")
@EqualsAndHashCode(callSuper = true)
public class Tutor extends User {


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    public Tutor(Long id, @NotNull(message = "Name cannot be null") @Size(min = 2, max = 50, message = "User name must be between 2 and 50 characters") String username, @NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email, String password, String role, Set<Course> enrolledCourses) {
        super(id, username, email, password, role, enrolledCourses);

    }


    public Tutor() {

    }
}
