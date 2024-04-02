/*
All the required validations for all the fields should be there
    1. questions should not be empty
    2. options length should be betweeen 2 to 5.
    3. answer should be a string with size 1.
    4. questionBank don't need any validations. 
*/

package com.iamneo.springboot.LMS.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String question;
    private List<String> options;
    private String answer;

    @ManyToOne
    private QuestionBank questionBank;
}
