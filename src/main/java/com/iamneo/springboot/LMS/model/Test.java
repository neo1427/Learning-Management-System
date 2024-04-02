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
