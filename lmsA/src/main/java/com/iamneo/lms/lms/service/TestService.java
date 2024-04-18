package com.iamneo.lms.lms.service;

import java.util.List;

import javax.validation.Valid;

import com.iamneo.lms.lms.dto.request.TestRequest;
import com.iamneo.lms.lms.model.Test;

public interface TestService {

    Test createTest(@Valid TestRequest testRequest);

    Test addQuestionsToTest(long testId, List<Long> questionIds);

    Test updateTest(long testId, TestRequest testRequest);

    // List<Answer> getAllTestByCourseId(String courseId);

}