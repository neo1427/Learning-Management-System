package com.iamneo.springboot.LMS.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;

    private String question;

    private short numCorrectAnswers;

    // @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Choice> options;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private QuestionBank questionBank;

    @JsonBackReference
    @ManyToMany
    // @JoinColumn(name = "test_id", referencedColumnName = "testId")
    private Set<Test> tests;
}
