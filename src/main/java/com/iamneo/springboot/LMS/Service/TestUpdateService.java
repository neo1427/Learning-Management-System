package com.iamneo.springboot.LMS.service;

import com.iamneo.springboot.LMS.model.Test;
import com.iamneo.springboot.LMS.repository.TestResultRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestUpdateService {

    private final TestResultRepository testRepository; // Dependency to access test data
    
    @Autowired
    public TestUpdateService(TestResultRepository testRepository) {
        this.testRepository = testRepository;
    }

    // public void updateTest(long testId, Test updatedTest) {
    //     // Validate parameters
    //     if (updatedTest == null) {
    //         throw new IllegalArgumentException("Updated test cannot be null");
    //     }

    //     // Check if the test with the given ID exists
    //     Test existingTest = testRepository.findAll(testId)
    //                                        .orElseThrow(() -> new IllegalArgumentException("Test not found"));

    //     // Update the existing test with the provided details
    //     existingTest.setName(updatedTest.getName());
    //     existingTest.setDuration(updatedTest.getDuration());
    //     // Add more properties to update as needed
        
    //     // Save the updated test to the database using the correct method
    //     testRepository.saveAll(existingTest);
    // }
}
