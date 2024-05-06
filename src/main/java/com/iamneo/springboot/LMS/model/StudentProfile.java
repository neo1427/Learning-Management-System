package com.iamneo.springboot.LMS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;

    @OneToOne
    private User user;

    private String name;

    private byte[] image;
    private Date dateOfBirth;
    private Date dateOfJoining;

    @OneToOne
    private Contact contact;

    @OneToOne
    private AcademicInfo academicInfos;

    private boolean isComplete;
}
