package com.example.lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lms.lms.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
