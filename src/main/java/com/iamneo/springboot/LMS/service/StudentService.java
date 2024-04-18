package com.iamneo.springboot.LMS.service;

import com.iamneo.springboot.LMS.dto.request.AnswerRequest;
import com.iamneo.springboot.LMS.model.Answer;
import com.iamneo.springboot.LMS.model.Test;

import java.util.List;

public interface StudentService {

    List<Test> getAllTests();

    Test getTestById(long testId);

    List<Test> getAllTestByCourseId(String courseId);

    Answer setAnswer(AnswerRequest answerRequest);

}
