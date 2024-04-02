/*
All the required validations for all the fields should be there
    1. name should be checked that it is not empty and not blank and not null.
    2. questions doesn't need any validation.
    3. teacherId should be checked that it is not empty and not blank and not null.
    4. tags doesn't need any validation.
*/

package com.iamneo.springboot.LMS.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class QuestionBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany
    private List<Question> questions;

    private String teacherId;
    private List<String> tags;
}
