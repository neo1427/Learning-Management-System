package com.example.lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lms.lms.model.QuestionBank;

public interface QuestionBankRepository extends JpaRepository<QuestionBank, Long> {

}
