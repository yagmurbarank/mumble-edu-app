package com.OnlineCoursePlatform.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class CourseCreateRequest {
    @NotNull(message = "title cannot be null")
    private String title;

    private String description;

    private Date startDate;
    private Date endDate;


}
