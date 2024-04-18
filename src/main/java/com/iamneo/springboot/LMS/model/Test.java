package com.iamneo.springboot.LMS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long testId;

    private String name;
    private String courseId;
    private LocalDateTime startDateTime;
    private int bufferTime;
    private int duration;

    // @JsonBackReference
    @ManyToMany
    @JoinTable(
        name = "questions_test",
        joinColumns = @JoinColumn(name = "test_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id_ans")
    )
    private Set<Question> questions;

    // @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY)
    private List<Answer> answer;
}
