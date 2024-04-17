package com.iamneo.springboot.LMS.service;

import java.util.List;

import javax.validation.Valid;

import com.iamneo.springboot.LMS.dto.request.TestRequest;
import com.iamneo.springboot.LMS.model.Test;


public interface TestService {

    Test createTest(@Valid TestRequest testRequest);

    Test addQuestionsToTest(long testId, List<Long> questionIds);

    Test updateTest(long testId, TestRequest testRequest);

    List<Test> getAllTests();

    Test getTestById(long testId);

    List<Test> getAllTestByCourseId(String courseId);

}
