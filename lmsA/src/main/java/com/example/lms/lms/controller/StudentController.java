package com.example.lms.lms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lms.lms.dto.response.BasicResponse;
import com.example.lms.lms.model.Test;
import com.example.lms.lms.service.TestService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/lms/student")
@RequiredArgsConstructor
public class StudentController {

    private final TestService testService;

    @PostMapping("/answer/{questionId}")
    public ResponseEntity<BasicResponse<String>> postMethodName(@RequestBody String entity) {
        
        return null;
    }

    // Get All tests that are there
    @GetMapping("/getAllTests")
    public ResponseEntity<BasicResponse<List<Test>>> getAllTests() {
        try {
            List<Test> tests = testService.getAllTests();
            BasicResponse<List<Test>> response = new BasicResponse<>("All tests fetched successfully", tests);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            BasicResponse<List<Test>> response = new BasicResponse<>("Failed to fetch tests: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
    // Get Test with test id
    @GetMapping("/getSpeceficTest/{testId}")
    public ResponseEntity<BasicResponse<Test>> getTestById(@PathVariable long testId) {
        try {
            Test test = testService.getTestById(testId);
            if (test != null) {
                BasicResponse<Test> response = new BasicResponse<>("Test fetched successfully", test);
                return ResponseEntity.ok(response);
            } else {
                BasicResponse<Test> response = new BasicResponse<>("Test not found", null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            BasicResponse<Test> response = new BasicResponse<>("Failed to fetch test: " + e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // get all test by course id
    @GetMapping("/getTestByCourse/{courseId}")
    public ResponseEntity<BasicResponse<List<Test>>> getMethodName(@PathVariable String courseId) {
        try {
            List<Test> tests = testService.getAllTestByCourseId(courseId);
            return ResponseEntity.ok(
                    BasicResponse.<List<Test>>builder().data(tests).message("Successfully fetched all tests").build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BasicResponse.<List<Test>>builder()
                    .data(null).message("Failed to fetch the test: " + e.getMessage()).build());
        }
    }

    
}
