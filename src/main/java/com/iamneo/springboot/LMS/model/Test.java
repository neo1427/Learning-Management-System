/*
All the required validations for all the fields should be there
    1. name should be checked for not empty and not blank and not null.
    2. studentId should be checked for not empty and not blank and not null nad no spaces are allowed.
    3. courseId should be checked for not empty and not blank and not null nad no spaces are allowed.
    4. startDate should be validated to check that only date of today and after is only allowed.
    5. startTime should be validated to check that only time of after now only allowed.
    6. bufferTime should be checked that it's atleast 1 minute.
    7. duration should be checked that it's atleast 5 minutes.
    8. questions doesn't need any validations.
*/

package com.iamneo.springboot.LMS.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is required")
    @Size(min = 1, message = "Name should not be empty")
    private String name;

    @NotBlank(message = "Student ID is required")
    @Size(min = 1, message = "Student ID should not be empty")
    private String studentId;

    @NotBlank(message = "Course ID is required")
    @Size(min = 1, message = "Course ID should not be empty")
    private String courseId;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @Min(value = 1, message = "Buffer time should be at least 1 minute")
    private int bufferTime;

    @Min(value = 5, message = "Duration should be at least 5 minutes")
    private int duration;

    @OneToMany
    private List<Question> questions;
}

