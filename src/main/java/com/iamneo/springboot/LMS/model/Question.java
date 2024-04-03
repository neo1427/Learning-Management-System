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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Question cannot be empty")
    private String question;
    @Size(min = 2, max = 5, message = "Options should have 2 to 5 elements")
    private List<String> options;

    @Size(min = 1, max = 1, message = "Answer should have exactly 1 character")
    private String answer;

    @ManyToOne
    private QuestionBank questionBank;
}
