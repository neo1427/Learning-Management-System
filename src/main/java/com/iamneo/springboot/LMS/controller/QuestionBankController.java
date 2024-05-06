package com.iamneo.springboot.LMS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.iamneo.springboot.LMS.dto.request.QuestionBankRequest;
import com.iamneo.springboot.LMS.dto.response.BasicResponse;
import com.iamneo.springboot.LMS.model.QuestionBank;
import com.iamneo.springboot.LMS.service.QuestionBankService;
import com.iamneo.springboot.LMS.utils.ServiceUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lms/teacher/questionbanks")
@RequiredArgsConstructor
@Validated
public class QuestionBankController {

    private final QuestionBankService questionBankService;
    private final ServiceUtil serviceUtil;

    // Create a new question bank
    @Operation(summary = "Create a new question bank", description = "This is the api endpoint that helps to add a new question bank that helps to add questions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully Created"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error Occured")
    })

    @PostMapping
    public ResponseEntity<BasicResponse<QuestionBank>> createQuestionBank(
            @Parameter(name="Question Bank", description="The details of the question bank you want to create") @RequestBody @Valid QuestionBankRequest questionBankRequest) {
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
    @Operation(summary = "Update the Question Bank details", description = "This is the api endpoint that helps to update the question bank details for the selected question bank")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Updated"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error Occured")
    })

    @PutMapping("/{id}")
    public ResponseEntity<BasicResponse<QuestionBank>> updateQuestionBank(
            @Parameter(name="Question Bank Id", description="Id of the Question bank we have to update", example="12345") @PathVariable long id,
            @Parameter(name= "New Question Bank Request", description="Details of the updated Question Bank") @RequestBody @Valid QuestionBankRequest questionBankRequest) {
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
    @Operation(summary = "Get all Question Banks", description = "This is the api endpoint that helps to retrieve all question banks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Retrieved"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error Occured")
    })

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
    @Operation(summary ="Get a Question Bank by Id", description="This is the api endpoint that helps to retrieve a question bank by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Retrieved"),
            @ApiResponse(responseCode = "500", description = "Unexpected Error Occured")
    })

    @GetMapping("/{questionBankId}")
    public ResponseEntity<BasicResponse<QuestionBank>> getQuestionBankFromQuestionId(
            @Parameter(name="Question Bank Id", description="Id of the Question bank we have to update", example="12345") @PathVariable Long questionBankId) {
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