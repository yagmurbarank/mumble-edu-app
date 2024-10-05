package com.OnlineCoursePlatform.model.request;

import com.OnlineCoursePlatform.model.Tutor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CourseRequestDTO {
    @NotNull(message = "title cannot be null")
    private String title;

    private String description;

    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;
}
