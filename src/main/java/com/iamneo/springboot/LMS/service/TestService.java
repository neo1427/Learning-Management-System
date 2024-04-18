package com.iamneo.springboot.LMS.service;

import com.iamneo.springboot.LMS.dto.request.TestRequest;
import com.iamneo.springboot.LMS.model.Test;

import javax.validation.Valid;
import java.util.List;

public interface TestService {

    Test createTest(@Valid TestRequest testRequest);

    Test addQuestionsToTest(long testId, List<Long> questionIds);

    Test updateTest(long testId, TestRequest testRequest);

    // List<Answer> getAllTestByCourseId(String courseId);

}
