package com.iamneo.springboot.LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.springboot.LMS.model.QuestionBank;

public interface QuestionBankRepository extends JpaRepository<QuestionBank, Long> {

}
