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
import lombok.Data;

@Entity
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String studentId;
    private String courseId;
    private LocalDate startDate;
    private LocalTime starTime;
    private int bufferTime;
    private int duration;

    @OneToMany
    private List<Question> questions;
}
