package com.OnlineCoursePlatform.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "title cannot be null")
    private String title;

    private String description;

    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "course")
    private Set<Enrollment> enrollments;


}
