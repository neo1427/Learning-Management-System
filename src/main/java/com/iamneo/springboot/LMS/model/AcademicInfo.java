package com.iamneo.springboot.LMS.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.iamneo.springboot.LMS.enumerated.MarkType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AcademicInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String institution;
    private String degree;
    private String major;
    private double marks;
    private MarkType markType;

    @OneToOne
    @JsonBackReference
    private StudentProfile studentProfile;
}
