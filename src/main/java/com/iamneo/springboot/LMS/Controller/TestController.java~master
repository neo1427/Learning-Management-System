package com.iamneo.springboot.LMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.iamneo.springboot.LMS.dto.request.TestRequest;
import com.iamneo.springboot.LMS.model.Test;
import com.iamneo.springboot.LMS.service.TestService;
import com.iamneo.springboot.LMS.dto.response.BasicResponse;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lms/teacher")
@Validated
public class TestController {

    @Autowired
    private TestService testService;

    // Create a new test
    @PostMapping("/addTest")
    public ResponseEntity<BasicResponse<Test>> createTest(@RequestBody @Valid TestRequest testRequest) {
        try {
            Test createdTest = testService.createTest(testRequest);
            BasicResponse<Test> response = new BasicResponse<>("Test created successfully", createdTest);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            BasicResponse<Test> response = new BasicResponse<>("Failed to create test: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Add questions to test
    @PostMapping("/addQuestions/{testId}")
    public ResponseEntity<BasicResponse<Test>> addQuestionsToTest(@PathVariable long testId,
            @RequestBody List<Long> questionIds) {
        try {
            Test updatedTest = testService.addQuestionsToTest(testId, questionIds);
            BasicResponse<Test> response = new BasicResponse<>("Questions added to test successfully", updatedTest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            BasicResponse<Test> response = new BasicResponse<>("Failed to add questions to test: " + e.getMessage(),
                    null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Update the test fro selected test
    @PutMapping("/updateTest/{testId}")
    public ResponseEntity<BasicResponse<Test>> updateTest(@PathVariable long testId,
            @RequestBody TestRequest testRequest) {
        try {
            Test updatedTest = testService.updateTest(testId, testRequest);
            BasicResponse<Test> response = new BasicResponse<>("Test updated successfully", updatedTest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            BasicResponse<Test> response = new BasicResponse<>("Failed to update test: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMap.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

}
