package com.example.lms.lms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.example.lms.lms.dto.request.QuestionBankRequest;
import com.example.lms.lms.dto.response.BasicResponse;
import com.example.lms.lms.model.QuestionBank;
import com.example.lms.lms.service.QuestionBankService;
import com.example.lms.lms.utils.ServiceUtil;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/lms/teacher/questionbanks")
@RequiredArgsConstructor
@Validated
public class QuestionBankController {

    private final QuestionBankService questionBankService;
    private final ServiceUtil serviceUtil;

    // Create a new question bank
    @PostMapping
    public ResponseEntity<BasicResponse<QuestionBank>> createQuestionBank(
            @RequestBody @Valid QuestionBankRequest questionBankRequest) {
        try {
            QuestionBank questionBank = serviceUtil.mapRequestToEntity(questionBankRequest);
            QuestionBank createdQuestionBank = questionBankService.createQuestionBank(questionBank);
            return ResponseEntity.status(HttpStatus.CREATED).body(BasicResponse.<QuestionBank>builder()
                    .data(createdQuestionBank).message("Question Bank Created Successfully").build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BasicResponse.<QuestionBank>builder().data(null).message(e.getMessage()).build());
        }
    }

    // Update Question bank details
    @PutMapping("/{id}")
    public ResponseEntity<BasicResponse<QuestionBank>> updateQuestionBank(@PathVariable long id,
            @RequestBody @Valid QuestionBankRequest questionBankRequest) {
        try {
            QuestionBank updatedQuestionBank = serviceUtil.mapRequestToEntity(questionBankRequest);
            QuestionBank result = questionBankService.updateQuestionBank(id, updatedQuestionBank);
            return ResponseEntity.ok(BasicResponse.<QuestionBank>builder().data(result)
                    .message("Question Bank Updated Successfully").build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BasicResponse.<QuestionBank>builder().data(null).message(e.getMessage()).build());
        }
    }

    // Get all question banks
    @GetMapping
    public ResponseEntity<BasicResponse<List<QuestionBank>>> getAllQuestionBanks() {
        try {
            List<QuestionBank> questionBanks = questionBankService.getAllQuestionBanks();
            return ResponseEntity.ok(BasicResponse.<List<QuestionBank>>builder().data(questionBanks)
                    .message("Successfully fetched all question banks").build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BasicResponse.<List<QuestionBank>>builder().data(null).message(e.getMessage()).build());
        }
    }

    // Get Question Bank from question bank id
    @GetMapping("/{questionBankId}")
    public ResponseEntity<BasicResponse<QuestionBank>> getQuestionBankFromQuestionId(
            @PathVariable Long questionBankId) {
        try {
            QuestionBank questionBank = questionBankService.findById(questionBankId);
            return ResponseEntity.ok(BasicResponse.<QuestionBank>builder().data(questionBank)
                    .message("Successfully fetched question bank").build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(BasicResponse.<QuestionBank>builder().data(null).message(e.getMessage()).build());
        }
    }

    
    // Exception handler for method argument validation errors
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
