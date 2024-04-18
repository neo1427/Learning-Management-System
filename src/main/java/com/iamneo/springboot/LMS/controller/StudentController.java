package com.iamneo.springboot.LMS.controller;

import com.iamneo.springboot.LMS.dto.request.AnswerRequest;
import com.iamneo.springboot.LMS.dto.response.BasicResponse;
import com.iamneo.springboot.LMS.model.Answer;
import com.iamneo.springboot.LMS.model.Test;
import com.iamneo.springboot.LMS.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/lms/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @Operation(summary = "Saves student's answer", description = "This API endpoint saves the answer submitted by a student for a question.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Answer saved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping("/answer/{questionId}")
    public ResponseEntity<BasicResponse<Answer>> studentAnswer(
            @PathVariable @Parameter(name = "Question Id", description = "From front end we'll get the The ID of the question", example = "Q1")
            @RequestBody AnswerRequest answerRequest) {
        try {
            Answer answer = studentService.setAnswer(answerRequest);
            return new ResponseEntity<>(
                    BasicResponse.<Answer>builder().data(answer).message("Answer saved successfully").build(),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(BasicResponse.<Answer>builder().data(null)
                    .message("Failed to save the answer: " + e.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get All tests that are there
    @GetMapping("/getAllTests")
    public ResponseEntity<BasicResponse<List<Test>>> getAllTests() {
        try {
            List<Test> tests = studentService.getAllTests();
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
            Test test = studentService.getTestById(testId);
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
            List<Test> tests = studentService.getAllTestByCourseId(courseId);
            return ResponseEntity.ok(
                    BasicResponse.<List<Test>>builder().data(tests).message("Successfully fetched all tests").build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BasicResponse.<List<Test>>builder()
                    .data(null).message("Failed to fetch the test: " + e.getMessage()).build());
        }
    }

}