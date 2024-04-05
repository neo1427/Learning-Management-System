package com.iamneo.springboot.LMS.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.iamneo.springboot.LMS.model.Test;
import com.iamneo.springboot.LMS.repository.TestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public Test updateTest(long testId, Test test) throws Exception {
        Optional<Test> opsTest = testRepository.findById(testId);
        if(opsTest.isEmpty()) throw new Exception("No test found with Id " + testId);
        test = testRepository.save(test);
        return test;
    }
    
}
