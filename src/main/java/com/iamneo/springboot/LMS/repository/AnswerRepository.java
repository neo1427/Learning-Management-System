package com.iamneo.springboot.LMS.repository;

import com.iamneo.springboot.LMS.model.Answer;
import com.iamneo.springboot.LMS.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findAllByTest(Test test);

}
