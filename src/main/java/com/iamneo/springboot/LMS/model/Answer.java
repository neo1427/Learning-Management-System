package com.iamneo.springboot.LMS.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    private String studentId;
    private float marks;

    @JsonBackReference
    @OneToOne
    private Question question;

    @JsonBackReference
    @OneToMany
    private List<Choice> answers;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "test", referencedColumnName = "testId")
    private Test test;
}
