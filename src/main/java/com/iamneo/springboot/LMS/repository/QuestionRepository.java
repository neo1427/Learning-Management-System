package com.iamneo.springboot.LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.springboot.LMS.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
