package com.OnlineCoursePlatform.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="Student")
@EqualsAndHashCode(callSuper = true)
public class Student extends User {

    @OneToMany
    @JoinColumn(name = "enrollment_id")
    private Set<Enrollment> enrollments;

    public Student(Long id, @NotNull(message = "Name cannot be null") @Size(min = 2, max = 50, message = "User name must be between 2 and 50 characters") String username, @NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email, String password, String role, Set<Course> enrollments) {
        super(id, username, email, password, role, enrollments);
    }
}
